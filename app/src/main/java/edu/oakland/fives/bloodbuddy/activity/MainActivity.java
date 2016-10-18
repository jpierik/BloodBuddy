package edu.oakland.fives.bloodbuddy.activity;


import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import edu.oakland.fives.bloodbuddy.R;
import edu.oakland.fives.bloodbuddy.adapter.RecyclerAdapter;
import edu.oakland.fives.bloodbuddy.model.DataModel;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.LandingAnimator;


public class MainActivity extends AppCompatActivity {

    //Todo: Fill in the correct names and units for tests
    //array of test names
    private String[] testCodes = {"WBC", "RBC", "HGB","HCT", "MCV", "MCH", "MCHC", "RDW", "PLT", "MPV",
    "NEUT %", "LYMPH %", "MONO %", "EOS %", "BASO %", "NEUT,ABS", "LYMPH,ABS", "MONO,ABS", "EOS,ABS",
    "BASO,ABS"};
    //array of the test units
    private String[] testUnits = {"Thousands/uL", "Millons/uL", "grams/dL",
            "%", "fL", "pg", "g/dL", "%", "Thousands/uL", "fL",
            "%", "%", "%", "%", "%", "Thousands/uL", "Thousands/uL", "Thousands/uL",
            "Thousands/uL", "Thousands/uL"};
    private ArrayList<DataModel> tests;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getTheme().applyStyle(R.style.MyRandomTheme, true);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);


//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//// | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//// | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //start app intro
         startAppIntro();

        //create recyclerview
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //define the arraylist
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



        //create a list view that has the test data
        createRecycleViewer(recyclerView, tests);

        //attach touch listener to recycle view itmes
        addTouchListenerToRecyclerView(recyclerView, tests);

//        button.setOnTouchListener( new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_UP:
//                        Log.v("tag", "end long click");
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            getWindow().setStatusBarColor(getResources().getColor(R.color.amber_600));
//                        }
//                        break;
//                    case MotionEvent.ACTION_DOWN:
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
//                        }
//                        Log.v("tag", "start long click");
//                        break;
//                    default:
//                        break;
//                }
//
//                return false;
//            }
//        });
    }


    private void createRecycleViewer(RecyclerView recyclerView, ArrayList<DataModel> tests) {
        RecyclerAdapter mAdapter = new RecyclerAdapter(getApplicationContext(), tests);

        LinearLayoutManager gridLayoutManager =
                new LinearLayoutManager(getApplicationContext());

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


    //test method to make sure values are collected correctly
    public void getTheData(View view) {


        ArrayList<DataModel> userTests = new ArrayList<>();
        for (DataModel dataModel : tests) {
            if (dataModel.getUserInput()) {
                userTests.add(dataModel);
            }
        }
        if(userTests.size()>0){
            TestValueAnalysis valueAnalysis = new TestValueAnalysis(userTests);
            valueAnalysis.analysis();

            BottomSheetDialogFragment bottomSheetDialogFragment = new ResultInformation();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tests", userTests);
            bottomSheetDialogFragment.setArguments(bundle);
            bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
        }
        else {
            Toast.makeText(getApplicationContext(), "No data entered!", Toast.LENGTH_SHORT).show();
        }



    }




    //touch listener method
    private void addTouchListenerToRecyclerView(final RecyclerView recyclerView, final ArrayList<DataModel> tests) {
        recyclerView.addOnItemTouchListener(new RecyclerAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {


            }

            @Override
            public void onLongClick(View view, int position) {
                BottomSheetDialogFragment bottomSheetDialogFragment = new TestInformation();
                Bundle bundle = new Bundle();
                bundle.putInt("testPosition", position);
                bottomSheetDialogFragment.setArguments(bundle);
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
            }
        }));
    }
    //app intro method
    private void startAppIntro() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStartVersion12", true);
                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    Intent i = new Intent(MainActivity.this, MyIntro.class);
                    startActivity(i);

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStartVersion12", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });

        // Start the thread
        t.start();
    }


}
