package com.mbcc.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;
import android.view.Gravity;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Collections;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 60000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    int[] unmatchedImages = new int[2];

    ImageButton one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen;
    int maxCounter = 0;
    int score = 0;
    final int maxFlipped = 3;
    TextView scoreNum;

    Integer[] allImages = { R.drawable.cheetah, R.drawable.cheetah, R.drawable.chick, R.drawable.chick, R.drawable.fox,
            R.drawable.fox, R.drawable.giraffe, R.drawable.giraffe, R.drawable.owl,
            R.drawable.owl, R.drawable.panda, R.drawable.panda, R.drawable.sheep, R.drawable.sheep, R.drawable.tiger,
            R.drawable.tiger};
    List<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.one);
        one.setEnabled(false);
        two = findViewById(R.id.two);
        two.setEnabled(false);
        three = findViewById(R.id.three);
        three.setEnabled(false);
        four = findViewById(R.id.four);
        four.setEnabled(false);
        five = findViewById(R.id.five);
        five.setEnabled(false);
        six = findViewById(R.id.six);
        six.setEnabled(false);
        seven = findViewById(R.id.seven);
        seven.setEnabled(false);
        eight = findViewById(R.id.eight);
        eight.setEnabled(false);
        nine = findViewById(R.id.nine);
        nine.setEnabled(false);
        ten = findViewById(R.id.ten);
        ten.setEnabled(false);
        eleven = findViewById(R.id.eleven);
        eleven.setEnabled(false);
        twelve = findViewById(R.id.twelve);
        twelve.setEnabled(false);
        thirteen = findViewById(R.id.thirteen);
        thirteen.setEnabled(false);
        fourteen = findViewById(R.id.fourteen);
        fourteen.setEnabled(false);
        fifteen = findViewById(R.id.fifteen);
        fifteen.setEnabled(false);
        sixteen = findViewById(R.id.sixteen);
        sixteen.setEnabled(false);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        imageList = Arrays.asList(allImages);
        Collections.shuffle(Arrays.asList(allImages));
        imageList.toArray(allImages);


        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();

                } else {
                    startTimer();
                }
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    public void onClick(View v) {
        final int id = v.getId();
        if (maxCounter < 2) {
            switch (id) {
                case R.id.one:
                    one.setBackgroundResource(allImages[0]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(0);
                    break;
                case R.id.two:
                    two.setBackgroundResource(allImages[1]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(1);
                    break;
                case R.id.three:
                    three.setBackgroundResource(allImages[2]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(2);
                    break;
                case R.id.four:
                    four.setBackgroundResource(allImages[3]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(3);

                    break;
                case R.id.five:
                    five.setBackgroundResource(allImages[4]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(4);
                    break;
                case R.id.six:
                    six.setBackgroundResource(allImages[5]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(5);
                    break;
                case R.id.seven:
                    seven.setBackgroundResource(allImages[6]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(6);
                    break;
                case R.id.eight:
                    eight.setBackgroundResource(allImages[7]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(7);
                    break;
                case R.id.nine:
                    nine.setBackgroundResource(allImages[8]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(8);
                    break;
                case R.id.ten:
                    ten.setBackgroundResource(allImages[9]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(9);
                    break;
                case R.id.eleven:
                    eleven.setBackgroundResource(allImages[10]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(10);
                    break;
                case R.id.twelve:
                    twelve.setBackgroundResource(allImages[11]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(11);
                    break;
                case R.id.thirteen:
                    thirteen.setBackgroundResource(allImages[12]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(12);
                    break;
                case R.id.fourteen:
                    fourteen.setBackgroundResource(allImages[13]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(13);
                    break;
                case R.id.fifteen:
                    fifteen.setBackgroundResource(allImages[14]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(14);
                    break;
                case R.id.sixteen:
                    sixteen.setBackgroundResource(allImages[15]);
                    unmatchedImages[maxCounter] = R.id.one;
                    unmatchedImages[maxCounter++] = imageList.get(15);
                    break;
            }
        }
        else {

            maxCounter= 0;

        }
        score();
    }

    public void score() {
        if (maxCounter == maxFlipped) {
            if (unmatchedImages[0] == R.drawable.cheetah && unmatchedImages[1] ==  R.drawable.cheetah) {
                increment();
                score++;
                maxCounter = 0;

                Context context = getApplicationContext();
                CharSequence text = "That's a match!";
                int duration = Toast.LENGTH_SHORT;

                Toast startToast = Toast.makeText(context, text, duration);
                startToast.show();

                startToast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 248);

            }
                  else {
                Context context = getApplicationContext();
                CharSequence text = "Not a match!";
                int duration = Toast.LENGTH_SHORT;

                Toast startToast = Toast.makeText(context, text, duration);
                startToast.show();

                startToast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 248);

                maxCounter= 0;

            }
        }
    }

    public void increment() {
        score++;
        scoreNum.setText(String.format("Score:%d/8", score));
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                one.setEnabled(true);
                two.setEnabled(true);
                three.setEnabled(true);
                four.setEnabled(true);
                five.setEnabled(true);
                six.setEnabled(true);
                seven.setEnabled(true);
                eight.setEnabled(true);
                nine.setEnabled(true);
                ten.setEnabled(true);
                eleven.setEnabled(true);
                twelve.setEnabled(true);
                thirteen.setEnabled(true);
                fourteen.setEnabled(true);
                fifteen.setEnabled(true);
                sixteen.setEnabled(true);
                updateCountDownText();

                Context context = getApplicationContext();
                CharSequence text = "Begin";
                int duration = Toast.LENGTH_SHORT;

                Toast startToast = Toast.makeText(context, text, duration);
                startToast.show();
                startToast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 248);
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setBackgroundResource(R.drawable.start);
                mButtonReset.setBackgroundResource(R.drawable.reset);
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
                one.setEnabled(false);
                two.setEnabled(false);
                three.setEnabled(false);
                four.setEnabled(false);
                five.setEnabled(false);
                six.setEnabled(false);
                seven.setEnabled(false);
                eight.setEnabled(false);
                nine.setEnabled(false);
                ten.setEnabled(false);
                eleven.setEnabled(false);
                twelve.setEnabled(false);
                thirteen.setEnabled(false);
                fourteen.setEnabled(false);
                fifteen.setEnabled(false);
                sixteen.setEnabled(false);

                Context context = getApplicationContext();
                CharSequence text = "Time's up!";
                int duration = Toast.LENGTH_SHORT;

                Toast startToast = Toast.makeText(context, text, duration);
                startToast.show();

                startToast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 248);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setBackgroundResource(R.drawable.pause);
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);
        ten.setEnabled(false);
        eleven.setEnabled(false);
        twelve.setEnabled(false);
        thirteen.setEnabled(false);
        fourteen.setEnabled(false);
        fifteen.setEnabled(false);
        sixteen.setEnabled(false);
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setBackgroundResource(R.drawable.start);
        mButtonReset.setVisibility(View.VISIBLE);
        mButtonReset.setBackgroundResource(R.drawable.reset);

        Context context = getApplicationContext();
        CharSequence text = "Game paused";
        int duration = Toast.LENGTH_SHORT;

        Toast startToast = Toast.makeText(context, text, duration);
        startToast.show();

        startToast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 248);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        score = 0;
        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);
        ten.setEnabled(false);
        eleven.setEnabled(false);
        twelve.setEnabled(false);
        thirteen.setEnabled(false);
        fourteen.setEnabled(false);
        fifteen.setEnabled(false);
        sixteen.setEnabled(false);
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
        one.setBackgroundResource(R.drawable.qmarks);
        two.setBackgroundResource(R.drawable.qmarks);
        three.setBackgroundResource(R.drawable.qmarks);
        four.setBackgroundResource(R.drawable.qmarks);
        five.setBackgroundResource(R.drawable.qmarks);
        six.setBackgroundResource(R.drawable.qmarks);
        seven.setBackgroundResource(R.drawable.qmarks);
        eight.setBackgroundResource(R.drawable.qmarks);
        nine.setBackgroundResource(R.drawable.qmarks);
        ten.setBackgroundResource(R.drawable.qmarks);
        eleven.setBackgroundResource(R.drawable.qmarks);
        twelve.setBackgroundResource(R.drawable.qmarks);
        thirteen.setBackgroundResource(R.drawable.qmarks);
        fourteen.setBackgroundResource(R.drawable.qmarks);
        fifteen.setBackgroundResource(R.drawable.qmarks);
        sixteen.setBackgroundResource(R.drawable.qmarks);
        Collections.shuffle(Arrays.asList(allImages));

        Context context = getApplicationContext();
        CharSequence text = "Press start";
        int duration = Toast.LENGTH_SHORT;

        Toast startToast = Toast.makeText(context, text, duration);
        startToast.show();

        startToast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 248);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), " %02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
        }
    }
