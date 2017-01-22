package com.example.sergio.quizmetestgui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.sergio.quizmetestgui.Question1.score;

public class newlayout extends AppCompatActivity {

    public static int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlayout);

        TextView txtView = (TextView) findViewById(R.id.finalscore);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if(bd != null)
        {
            String getName = (String) bd.get("name");
            score = Integer.parseInt(getName);
            txtView.setText(getName);
        }
    }

    public void backmenu(View view){
        Intent i = new Intent(this, UserDashBoard.class);
        startActivity(i);
    }

}
