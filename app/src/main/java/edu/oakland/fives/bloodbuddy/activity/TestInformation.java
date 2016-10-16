package edu.oakland.fives.bloodbuddy.activity;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import edu.oakland.fives.bloodbuddy.R;

/**
 * Created by Serar on 10/15/2016.
 */

public class TestInformation extends BottomSheetDialogFragment {


    private TextView textviewNames;
    private String[] testnames, testInfo;
    private TextView textviewInfo;

    @Override
    public void setupDialog(final Dialog dialog, int style) {
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_bottom_sheet, null);
        dialog.setContentView(contentView);
        int position =  getArguments().getInt("testPosition");
        textviewInfo = (TextView)dialog.findViewById(R.id.test_info);
        textviewNames = (TextView)dialog.findViewById(R.id.text);
        Resources res = getResources();
        testnames = res.getStringArray(R.array.tests_array);
        testInfo = res.getStringArray(R.array.testsInfo_array);

        showTestInfo(position);

    }

    private void showTestInfo(int position) {
        try {
            textviewNames.setText(testnames[position]);
            textviewInfo.setText(testInfo[position]);

        }catch (Exception exception){

        }
    }

}
