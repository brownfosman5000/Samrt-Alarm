package com.example.fosterbrown.smartalarm;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.graphics.Color;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class Simon extends AppCompatActivity {

    Button red, blue, green, yellow, start, check;
    final int[] pattern = {2, 4, 1, 3, 2, 1};
    static int[] user_choice = new int[6];
    static int num_clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);

        red = findViewById(R.id.redButton);
        blue = findViewById(R.id.blueButton);
        green = findViewById(R.id.greenButton);
        yellow = findViewById(R.id.yellowButton);
        start = findViewById(R.id.start_pattern);
        check = findViewById(R.id.check);

        red.setBackgroundColor(Color.RED);
        blue.setBackgroundColor(Color.BLUE);
        green.setBackgroundColor(Color.GREEN);
        yellow.setBackgroundColor(Color.YELLOW);


        setUpClick(red);
        setUpClick(blue);
        setUpClick(green);
        setUpClick(yellow);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playPatternAnimation(pattern);
                Log.d("tag", "Button Clicked and Pattern played");
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrect(pattern);
            }
        });


    }


    //Which button,Color strings for the lighter color and int color for the normal colors
    private void setUpClick(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                button.startAnimation(animation);

                Log.d("tag",button.getText().toString());
                if (button.getText().toString() == "Red") {
                    user_choice[num_clicks] = 1;
                    Log.d("tag","red was clicked");
                }
                else if (button.getText() == "Blue")
                    user_choice[num_clicks] = 2;

                else if (button.getText() == "Green")
                    user_choice[num_clicks] = 3;

                else if (button.getText() == "Yellow")
                    user_choice[num_clicks] = 4;

                num_clicks++;

                Log.d("tag", Arrays.toString(user_choice) + num_clicks);

            }
        });
    }

    private void playPatternAnimation(int pattern_selection[]) {
        int num_selections = pattern_selection.length;
        Animation animation = new AlphaAnimation(1.0f, 0.5f);
        animation.setDuration(300);


        Log.d("tag", "Pattern is being played");
        for (int i = 0; i < num_selections; i++) {
            if (pattern_selection[i] == 1) {
                red.startAnimation(animation);

            } else if (pattern_selection[i] == 2) {
                blue.startAnimation(animation);


            } else if (pattern_selection[i] == 3) {
                green.startAnimation(animation);

            } else if (pattern_selection[i] == 4) {
                yellow.startAnimation(animation);

            }

        }
    }
//
//    private void checkPatterns(){
//


    private void checkCorrect(final int pattern_selection[]) {
        for (int i = 0; i < pattern_selection.length; i++) {
            if (pattern_selection[i] == user_choice[i]) {
                Log.d("tag", "Matches");

            } else {
                Log.d("tag", "Didn't match moving on");
                break;
            }
        }
    }

}






//        LinearLayout linearLayout = new LinearLayout(this);
//        Button redButton = new Button(this);
//        Button greenButton = new Button(this);
//        Button blueButton = new Button(this);
//        Button yellowButton = new Button(this);
//
//
//        Log.d("tag","Converted");
//
//
//
//
//        //Setting size,color,and text
//        addAttributes(redButton,Color.RED,"Red");
//        addAttributes(greenButton,Color.GREEN,"Green");
//
//        addAttributes(blueButton,Color.BLUE,"Blue");
//        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(rlp);
//
//        linearLayout.addView(redButton,rlp);
//        linearLayout.addView(greenButton,rlp);
//        linearLayout.addView(blueButton,lp);
//    private void addAttributes(Button button,int color,String text){
//        button.setBackgroundColor(color);
//        button.setText(text);
//        createSimonButtonSize(button);
//    }
//    private void createSimonButtonSize(Button button){
//        Resources r = getResources();
//        int heightdpi = (int) (r.getDisplayMetrics().heightPixels / r.getDisplayMetrics().density);
//        int widthdpi = (int) (r.getDisplayMetrics().widthPixels / r.getDisplayMetrics().density);
//
//        int heightpx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,heightdpi/2,r.getDisplayMetrics());
//        int widthpx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,widthdpi/2,r.getDisplayMetrics());
//        button.setWidth(widthpx);
//        button.setHeight(heightpx);
//    }


