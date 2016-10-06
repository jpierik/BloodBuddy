package edu.oakland.fives.bloodbuddy.adapter;

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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<DataModel> tests;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView testName;
        TextView testUnits;
        EditText userValue;
        public MyViewHolder(View view) {
            super(view);

            testName = (TextView)view.findViewById(R.id.textViewName);
            testUnits = (TextView)view.findViewById(R.id.textViewUnits);
            userValue = (EditText)view.findViewById(R.id.editText);

        }
    }


    public RecyclerAdapter(Context context, ArrayList<DataModel> tests) {
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
                .inflate(R.layout.data_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final DataModel dataModel = tests.get(position);
        holder.testName.setText(dataModel.getTestName());
        holder.testUnits.setText(dataModel.getTestUnits());

        //add listener to get the data from text fields once user change values
        holder.userValue.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                try {
                    if(!s.equals("")){
                        Double ans = Double.parseDouble(s.toString());
                        tests.get(position).setValue(ans);
                    }
                }catch (Exception e){
                    tests.get(position).setValue(0);
                }


            }
        });



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
