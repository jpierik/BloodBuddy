package edu.oakland.fives.bloodbuddy.activity;



import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import edu.oakland.fives.bloodbuddy.R;
import edu.oakland.fives.bloodbuddy.adapter.RecyclerAdapter;
import edu.oakland.fives.bloodbuddy.model.DataModel;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.LandingAnimator;


public class MainActivity extends AppCompatActivity {


    private ArrayList<DataModel> tests;
    private RadioGroup radioGroupGender;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeContainer;
    private ArrayList<DataModel> userTests;
    private String[] testNames;
    private String[] testUnits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getTheme().applyStyle(R.style.MyRandomTheme, true);
        setContentView(R.layout.activity_main);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        Resources res = getResources();
        testNames = res.getStringArray(R.array.tests_array);
        testUnits = res.getStringArray(R.array.testUnits_array);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);


//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//// | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//// | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //start app intro
        // startAppIntro();
        
        //show discliamer
       // showDialog(0);

        //create recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //define the arraylist
        tests = new ArrayList<>();
      //  ActivityManager.TaskDescription tDesc = new ActivityManager.TaskDescription(null,null,getColor(R.color.yellow_700));
       // this.setTaskDescription(tDesc);
        //insert the test information into the data model and then add the data to the arraylist




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
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                AlertDialog diaBox = confirmClearData();
                diaBox.show();

            }
        });
    }
    private AlertDialog confirmClearData()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Clear Data!")
                .setMessage("Are you sure you want to clear all entered data?")
                .setIcon(android.R.drawable.ic_delete)

                .setPositiveButton("Clear", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        //your deleting code
                        clearData();
                        dialog.dismiss();

                    }

                })



                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        swipeContainer.setRefreshing(false);
                        dialog.dismiss();

                    }
                })
                .create();
        swipeContainer.setRefreshing(false);
        return myQuittingDialogBox;

    }

    private void clearData() {
        if(tests!=null){
            if(userTests!=null){
                userTests.clear();
            }

            tests.clear();
            createRecycleViewer(recyclerView, tests);
        }


        //tests.clear();


        swipeContainer.setRefreshing(false);
    }


    private void createRecycleViewer(RecyclerView recyclerView, ArrayList<DataModel> tests) {

        for(int i = 0; i< testNames.length; i++){
            DataModel dataModel = new DataModel();
            dataModel.setTestName(testNames[i]);
            dataModel.setTestUnits(testUnits[i]);
            tests.add(dataModel);
        }
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

        //listen to scroll..hide keyboard
        recyclerView.addOnScrollListener(new CustomScrollListener());
    }


    //test method to make sure values are collected correctly
    public void getTheData(View view) {

        View view2 = getCurrentFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if (view2 != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        int selectedGenderID = radioGroupGender.getCheckedRadioButtonId();

        RadioButton radioGenderButton = (RadioButton) findViewById(selectedGenderID);

        userTests = new ArrayList<>();
        for (DataModel dataModel : tests) {
            if (dataModel.getUserInput()) {
                userTests.add(dataModel);
            }
        }
        if(userTests.size()>0){
            TestValueAnalysis valueAnalysis = new TestValueAnalysis(getApplicationContext(),userTests, radioGenderButton.getText().toString());
            valueAnalysis.analysis();

            BottomSheetDialogFragment bottomSheetDialogFragment = new ResultInformation();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tests", userTests);
            bundle.putString("gender", radioGenderButton.getText().toString());
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

//    protected Dialog onCreateDialog(int id){
//        // show disclaimer....
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("LEGAL DISCLAIMER:").setMessage(getResources().getString(R.string.disclaimer_summary)).setView(LayoutInflater.from(this).inflate(R.layout.disclaimer_dialog,null))
//                .setCancelable(false)
//                .setPositiveButton("Agree", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //accept
//                    }
//                })
//                .setNegativeButton("Disagree", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        //exit
//                        System.exit(0);
//                    }
//                });
//        AlertDialog alert = builder.create();
//        return alert;
//    }
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Performing tis action will take you back to home activity which will result of lost of all data you may entered. Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        MainActivity.super.onBackPressed();
                        overridePendingTransition(R.anim.left_in, R.anim.right_out);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }


    //scroll listener
    class CustomScrollListener extends RecyclerView.OnScrollListener {
        CustomScrollListener(){
        }
        public void onScrollStateChanged(RecyclerView recyclerView, int newState){
            switch (newState) {
                case RecyclerView.SCROLL_STATE_IDLE:
                    System.out.println("The RecyclerView is not scrolling");
                    break;
                case RecyclerView.SCROLL_STATE_DRAGGING:
                    System.out.println("Scrolling now");
                    View view = getCurrentFocus();
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (view != null) {
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                    break;
                case RecyclerView.SCROLL_STATE_SETTLING:
                    System.out.println("Scroll Settling");
                    break;

            }

        }



    }


}
