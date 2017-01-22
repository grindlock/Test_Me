package com.example.sergio.quizmetestgui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.sergio.quizmetestgui.Question1.score;

public class question2 extends AppCompatActivity {

    CountDownTimer timer;
    public static long time;

    public static int score1;

    private static Button button_sm;
    private static Button button_sm2;
    private static Button button_sm3;
    private static Button button_sm4;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        TextView txtView = (TextView) findViewById(R.id.score2);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if(bd != null)
        {
            String getName = (String) bd.get("name");
            score1 = Integer.parseInt(getName);
            txtView.setText(getName);
        }

        onClickButtonListener();


        timer = new CountDownTimer(15000, 1000) {

            TextView time_holder = (TextView)findViewById(R.id.mytime2);

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
                Intent i = new Intent("com.example.sergio.quizmetestgui.question3");
                i.putExtra("name",String.valueOf(score1));
                startActivity(i);
            }

        }.start();

    }

    public void onClickButtonListener(){

        button_sm = (Button)findViewById(R.id.button5);

        button_sm.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        score1= score1+100*(int)time;

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question3");
                        intent.putExtra("name",String.valueOf(score1));
                        startActivity(intent);
                    }
                }
        );

        button_sm2 = (Button)findViewById(R.id.button6);

        button_sm2.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question3");
                        intent.putExtra("name",String.valueOf(score1));
                        startActivity(intent);
                    }
                }
        );

        button_sm3 = (Button)findViewById(R.id.button7);

        button_sm3.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question3");
                        intent.putExtra("name",String.valueOf(score1));
                        startActivity(intent);
                    }
                }
        );
        button_sm4 = (Button)findViewById(R.id.button8);

        button_sm4.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View v){

                        timer.cancel();

                        Intent intent = new Intent("com.example.sergio.quizmetestgui.question3");
                        intent.putExtra("name",String.valueOf(score1));
                        startActivity(intent);
                    }
                }
        );

    }
}
