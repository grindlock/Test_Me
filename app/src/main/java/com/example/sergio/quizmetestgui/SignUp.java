package com.example.sergio.quizmetestgui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.data;

/**
 * Created by sergio on 1/21/17.
 */

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser user;
    private DatabaseReference ref;
    ProgressDialog progress;
    EditText nEmail;
    EditText nPassword;
    EditText nfname;
    EditText nlname;
    EditText nUsername;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        nEmail = (EditText)findViewById(R.id.emailCreate);
        nPassword = (EditText)findViewById(R.id.passwordCreate);
        nfname = (EditText)findViewById(R.id.fname);
        nlname = (EditText)findViewById(R.id.lname);
        nUsername = (EditText)findViewById(R.id.usernameCreate);

        progress = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        ref = FirebaseDatabase.getInstance().getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());

                } else {
                    // User is signed out
                    Log.d("TAG", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

public void registerUser(View view){
    progress.setMessage("Registering User...");
    progress.show();

    mAuth.createUserWithEmailAndPassword(nEmail.getText().toString(), nPassword.getText().toString())
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            Log.d("TAG", "createUserWithEmail:onComplete:" + task.isSuccessful());

            // If sign in fails, display a message to the user. If sign in succeeds
            // the auth state listener will be notified and logic to handle the
            // signed in user can be handled in the listener

            progress.hide();
            if (!task.isSuccessful()) {
                Toast.makeText(SignUp.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                user = mAuth.getInstance().getCurrentUser();
                writeUser(user.getUid(), nfname.getText().toString(), nlname.getText().toString(), nEmail.getText().toString(), nUsername.getText().toString() );
                Toast.makeText(SignUp.this, "Registed succefully",
                        Toast.LENGTH_SHORT).show();
                if(user != null){
                    Intent intent = new Intent(SignUp.this, UserDashBoard.class);
                    intent.putExtra("USER_ID", user.getUid());
                    startActivity(intent);
                }

                //Intent to the dashboard.

            }

            // ...
        }
    });
}

    public void writeUser(String uid, String fname, String lname, String email, String username){
            User user = new User(fname, lname, email, username);
            ref.child("users").child(uid).setValue(user);
    }
}
