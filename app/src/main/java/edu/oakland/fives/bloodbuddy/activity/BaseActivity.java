package edu.oakland.fives.bloodbuddy.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import edu.oakland.fives.bloodbuddy.R;

public class BaseActivity extends AppCompatActivity {
    private TextView disclaimerText, showMoreLess;
    private CheckBox checkBox;
    private boolean expanded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        disclaimerText = (TextView)findViewById(R.id.policy_text);
        showMoreLess = (TextView)findViewById(R.id.text_show);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        expanded=false;
        //start app intro
         startAppIntro();

    }
    public void expand(View view) {
        if(expanded){
            cycleTextViewCollapse(disclaimerText);
            showMoreLess.setText("show more");
            expanded=false;
        }
        else {
            cycleTextViewExpansion(disclaimerText);
            showMoreLess.setText("show less");
            expanded=true;
        }
    }
    private void cycleTextViewExpansion(TextView tv){
        int collapsedMaxLines = 40;
        ObjectAnimator animation = ObjectAnimator.ofInt(tv, "maxLines",
                tv.getMaxLines() == collapsedMaxLines? tv.getLineCount() : collapsedMaxLines);
        animation.setDuration(200).start();
    }
    private void cycleTextViewCollapse(TextView tv){
        int collapsedMaxLines = 4;
        ObjectAnimator animation = ObjectAnimator.ofInt(tv, "maxLines",
                tv.getMaxLines() == collapsedMaxLines? tv.getLineCount() : collapsedMaxLines);
        animation.setDuration(200).start();
    }

    public void goMain(View view) {

        if(checkBox.isChecked()){
            Intent intent=new Intent(BaseActivity.this,MainActivity.class);
            startActivityForResult(intent,0);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
        else {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
            Snackbar.make(coordinatorLayout,"Please read and accept disclaimer first!",Snackbar.LENGTH_SHORT).show();
        }

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
                    Intent i = new Intent(BaseActivity.this, MyIntro.class);
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
