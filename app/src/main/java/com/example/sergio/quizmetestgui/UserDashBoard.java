package com.example.sergio.quizmetestgui;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.QuoteSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.internal.zzbjp;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserDashBoard extends AppCompatActivity {
    String user_id;
    TextView username;
    Button play;
    Button chat;
String uname;
final List<User> objs = new ArrayList<>();
     FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dash_board);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        play = (Button)findViewById(R.id.play);
        chat = (Button)findViewById(R.id.chat);

        user_id = bundle != null ? bundle.getString("USER_ID"):"";
        username = (TextView) findViewById(R.id.username);
        username.setText(user_id);

    }

    public void play(View view){
        Intent i = new Intent(this, Question1.class);
        startActivity(i);
    }
    public void chat(View view){
        Intent i = new Intent(this, MainActivityChat.class);
        startActivity(i);
    }
}
