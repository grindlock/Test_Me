package com.example.sergio.quizmetestgui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class question3 extends AppCompatActivity {

    CountDownTimer timer;
    public static long time;

    public static int score2;

    private static Button button_s;
    private static Button button_s2;
    private static Button button_s3;
    private static Button button_s4;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        TextView txtView = (TextView) findViewById(R.id.score3);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if(bd != null)
        {
            String getName = (String) bd.get("name");
            score2 = Integer.parseInt(getName);
            txtView.setText(getName);
        }
        onClickButtonListener();


        timer = new CountDownTimer(15000, 1000) {

            TextView time_holder = (TextView)findViewById(R.id.mytime3);

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
                Intent i = new Intent("com.example.sergio.quizmetestgui.question4");
                i.putExtra("name",String.valueOf(score2));
                startActivity(i);
            }

        }.start();

    }


    public void onClickButtonListener(){

        button_s = (Button)findViewById(R.id.button9);

        button_s.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question4");
                        intent.putExtra("name",String.valueOf(score2));
                        startActivity(intent);
                    }
                }
        );

        button_s2 = (Button)findViewById(R.id.button10);

        button_s2.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        score2 = score2 +(int)time*100;

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question4");
                        intent.putExtra("name",String.valueOf(score2));
                        startActivity(intent);
                    }
                }
        );

        button_s3 = (Button)findViewById(R.id.button11);

        button_s3.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question4");
                        intent.putExtra("name",String.valueOf(score2));
                        startActivity(intent);
                    }
                }
        );
        button_s4 = (Button)findViewById(R.id.button12);

        button_s4.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question4");
                        intent.putExtra("name",String.valueOf(score2));
                        startActivity(intent);
                    }
                }
        );

    }
}
