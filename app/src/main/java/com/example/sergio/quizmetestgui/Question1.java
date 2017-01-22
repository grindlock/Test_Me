package com.example.sergio.quizmetestgui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;


public class Question1 extends AppCompatActivity {

    CountDownTimer timer;
    public static long time;

    public static int score;

    private static Button button_sbm;
    private static Button button_sbm2;
    private static Button button_sbm3;
    private static Button button_sbm4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_question1);
        onClickButtonListener();
        score=0;

        timer = new CountDownTimer(15000, 1000) {

            TextView time_holder = (TextView)findViewById(R.id.mytime);

            public void onTick(long millisUntilFinished) {

                time = millisUntilFinished / 1000;
                time_holder.setText("seconds remaining: " + time);
            }

            public void onFinish() {

                time_holder.setText("Time's up!");

                new Handler().postDelayed(new Runnable() {
                    @Override

                    public void run() {
                        next();
                    }
                }, 3000);
            }

            public void next()
            {
                Intent i = new Intent("com.example.sergio.quizmetestgui.question2");
                i.putExtra("name",String.valueOf(score));
                startActivity(i);
            }

        }.start();
    }

    public void onClickButtonListener(){

        button_sbm = (Button)findViewById(R.id.button1);

        button_sbm.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question2");
                        intent.putExtra("name",String.valueOf(score));
                        startActivity(intent);
                    }
                }
        );

        button_sbm2 = (Button)findViewById(R.id.button2);

        button_sbm2.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question2");
                        intent.putExtra("name",String.valueOf(score));
                        startActivity(intent);
                    }
                }
        );

        button_sbm3 = (Button)findViewById(R.id.button3);

        button_sbm3.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        score = score + 100*(int)time;

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question2");
                        intent.putExtra("name",String.valueOf(score));
                        startActivity(intent);
                    }
                }
        );

        button_sbm4 = (Button)findViewById(R.id.button4);

        button_sbm4.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question2");
                        intent.putExtra("name",String.valueOf(score));
                        startActivity(intent);
                    }
                }
        );

    }

}
