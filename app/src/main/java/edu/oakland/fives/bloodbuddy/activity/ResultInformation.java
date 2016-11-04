package edu.oakland.fives.bloodbuddy.activity;

/**
 * Created by Serar on 10/16/2016.
 */

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import edu.oakland.fives.bloodbuddy.R;
import java.util.ArrayList;
import edu.oakland.fives.bloodbuddy.adapter.ResultsAdapter;
import edu.oakland.fives.bloodbuddy.model.DataModel;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.LandingAnimator;

/**
 * Created by Serar on 10/15/2016.
 */

public class ResultInformation extends BottomSheetDialogFragment {



    @Override
    public void setupDialog(final Dialog dialog, int style) {
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_result_sheet, null);
        dialog.setContentView(contentView);

        //create recyclerview
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.recycler_view2);
        final ImageView arrow = (ImageView) dialog.findViewById(R.id.arrow_up);

        ArrayList<DataModel> tests = (ArrayList<DataModel>) getArguments().getSerializable("tests");
        createRecycleViewer(recyclerView, tests);
        final Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in_out);
        arrow.startAnimation(anim);


        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                arrow.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


    public void createRecycleViewer(RecyclerView recyclerView, ArrayList<DataModel> tests) {
        ResultsAdapter mAdapter = new ResultsAdapter(getContext(), tests);

        LinearLayoutManager gridLayoutManager =
                new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(gridLayoutManager);
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(mAdapter);
        scaleInAnimationAdapter.setDuration(1500);
        scaleInAnimationAdapter.setFirstOnly(false);
        scaleInAnimationAdapter.setInterpolator(new OvershootInterpolator());
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(scaleInAnimationAdapter);
        alphaAdapter.setDuration(200);
        alphaAdapter.setFirstOnly(false);
        RecyclerView.ItemAnimator itemAnimator = new LandingAnimator();
        itemAnimator.setAddDuration(250);
        itemAnimator.setRemoveDuration(250);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(alphaAdapter);
        alphaAdapter.setFirstOnly(false);
        scaleInAnimationAdapter.setFirstOnly(false);

    }

}
