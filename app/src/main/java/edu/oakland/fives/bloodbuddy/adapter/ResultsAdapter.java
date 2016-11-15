package edu.oakland.fives.bloodbuddy.adapter;

/**
 * Created by Serar on 10/16/2016.
 */

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import edu.oakland.fives.bloodbuddy.R;
import edu.oakland.fives.bloodbuddy.model.DataModel;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import edu.oakland.fives.bloodbuddy.R;
import edu.oakland.fives.bloodbuddy.model.DataModel;
import java.util.ArrayList;

/**
 * Created by Serar on 9/25/2016.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.MyViewHolder> {

    private ArrayList<DataModel> tests;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView testName;
        TextView testUnits;
        TextView resultSummary;
        TextView resultValue;
        ProgressBar progressBar;
        ImageView low, normal,high;

        public MyViewHolder(View view) {
            super(view);

            testName = (TextView)view.findViewById(R.id.textViewName);
            testUnits = (TextView)view.findViewById(R.id.textViewUnits);
            resultValue =(TextView)view.findViewById(R.id.textViewValue);
            resultSummary = (TextView)view.findViewById(R.id.test_result_summary);
            progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
            low = (ImageView)view.findViewById(R.id.arrow_low);
            normal = (ImageView)view.findViewById(R.id.arrow_normal);
            high = (ImageView)view.findViewById(R.id.arrow_high);


        }
    }


    public ResultsAdapter(Context context, ArrayList<DataModel> tests) {
        mContext = context;
        this.tests = tests;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_data_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final DataModel dataModel = tests.get(position);
        holder.testName.setText(dataModel.getTestName());
        holder.testUnits.setText(dataModel.getTestUnits());
        holder.resultSummary.setText(dataModel.getAnalysis());
        //holder.progressBar.setProgress(dataModel.getRange());
        holder.resultValue.setText("Value: "+dataModel.getValue());
        switch (dataModel.getRange()){
            case 1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
                    holder.low.setVisibility(View.VISIBLE);
                    holder.progressBar.setProgress(1);
                }
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
                    holder.normal.setVisibility(View.VISIBLE);
                    holder.progressBar.setProgress(3);
                }
                break;
            case 3:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
                    holder.high.setVisibility(View.VISIBLE);
                    holder.progressBar.setProgress(5);
                }
                break;
        }



    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}

