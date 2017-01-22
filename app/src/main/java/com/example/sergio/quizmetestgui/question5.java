package com.example.sergio.quizmetestgui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class question5 extends AppCompatActivity {

    CountDownTimer timer;
    public static long time;

    public static int score4;

    private static Button button1;
    private static Button button2;
    private static Button button3;
    private static Button button4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        TextView txtView = (TextView) findViewById(R.id.score5);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if (bd != null) {

            String getName = (String) bd.get("name");
            score4 = Integer.parseInt(getName);
            txtView.setText(getName);
        }

        onClickButtonListener();

        timer = new CountDownTimer(15000, 1000) {

            TextView time_holder = (TextView) findViewById(R.id.mytime5);

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

            public void next() {
                Intent i = new Intent("com.example.sergio.quizmetestgui.newlayout");
                i.putExtra("name",String.valueOf(score4));
                startActivity(i);
            }
        }.start();
    }

    public void onClickButtonListener() {

        button1 = (Button) findViewById(R.id.button17);

        button1.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        timer.cancel();
                        Intent intent = new Intent("com.example.sergio.quizmetestgui.newlayout");
                        intent.putExtra("name", String.valueOf(score4));
                        startActivity(intent);
                    }
                }

        );


        button2 = (Button)findViewById(R.id.button18);

        button2.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        score4 = score4 +(int)time*100;

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.newlayout");
                        intent.putExtra("name",String.valueOf(score4));
                        startActivity(intent);
                    }
                }

        );


        button3 = (Button)findViewById(R.id.button19);

        button3.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();
                        Intent intent = new Intent("com.example.sergio.quizmetestgui.newlayout");
                        intent.putExtra("name",String.valueOf(score4));
                        startActivity(intent);
                    }
                }

        );


        button4 = (Button)findViewById(R.id.button20);

        button4.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.newlayout");
                        intent.putExtra("name",String.valueOf(score4));
                        startActivity(intent);
                    }
                }

        );


    }









}




