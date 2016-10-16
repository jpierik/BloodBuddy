package edu.oakland.fives.bloodbuddy.activity;

/**
 * Created by Serar on 10/16/2016.
 */

import android.app.Dialog;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import edu.oakland.fives.bloodbuddy.R;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import edu.oakland.fives.bloodbuddy.R;
import edu.oakland.fives.bloodbuddy.adapter.RecyclerAdapter;
import edu.oakland.fives.bloodbuddy.adapter.ResultsAdapter;
import edu.oakland.fives.bloodbuddy.model.DataModel;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.LandingAnimator;

/**
 * Created by Serar on 10/15/2016.
 */

public class ResultInformation extends BottomSheetDialogFragment {


    private TextView textviewNames;
    private String[] testnames, testInfo;
    private TextView textviewInfo;
    private String[] testCodes = {"WBC", "RBC", "HGB","HCT", "MCV", "MCH", "MCHC", "RDW", "PLT", "MPV",
            "NEUT %", "LYMPH %", "MONO %", "EOS %", "BASO %", "NEUT,ABS", "LYMPH,ABS", "MONO,ABS", "EOS,ABS",
            "BASO,ABS"};
    //array of the test units
    private String[] testUnits = {"Thousands/uL", "Millons/uL", "grams/dL",
            "%", "fL", "pg", "g/dL", "%", "Thousands/uL", "fL",
            "%", "%", "%", "%", "%", "Thousands/uL", "Thousands/uL", "Thousands/uL",
            "Thousands/uL", "Thousands/uL"};
    private ArrayList<DataModel> tests;

    @Override
    public void setupDialog(final Dialog dialog, int style) {
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_result_sheet, null);
        dialog.setContentView(contentView);
        textviewInfo = (TextView)dialog.findViewById(R.id.test_info);
        textviewNames = (TextView)dialog.findViewById(R.id.text);
        Resources res = getResources();
        testnames = res.getStringArray(R.array.tests_array);
        testInfo = res.getStringArray(R.array.testsInfo_array);
        //create recyclerview
        RecyclerView recyclerView = (RecyclerView) dialog.findViewById(R.id.recycler_view2);

        tests = new ArrayList<>();
        //  ActivityManager.TaskDescription tDesc = new ActivityManager.TaskDescription(null,null,getColor(R.color.yellow_700));
        // this.setTaskDescription(tDesc);
        //insert the test information into the data model and then add the data to the arraylist
        for(int i =0;i<testCodes.length;i++){
            DataModel dataModel = new DataModel();
            dataModel.setTestName(testCodes[i]);
            dataModel.setTestUnits(testUnits[i]);
            tests.add(dataModel);
        }
        createRecycleViewer(recyclerView, tests);

    }

    private void showTestInfo(int position) {
        try {
            textviewNames.setText(testnames[position]);
            textviewInfo.setText(testInfo[position]);

        }catch (Exception exception){

        }
    }

    private void createRecycleViewer(RecyclerView recyclerView, ArrayList<DataModel> tests) {
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
