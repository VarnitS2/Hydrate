package com.example.hydrate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class LogInActivity extends AppCompatActivity {

    /** FirebaseAuth instance. */
    private FirebaseAuth mAuth;

    /** User's email. */
    private TextView email;

    /** User's password. */
    private TextView password;

    /** Log in button. */
    private Button logIn;

    /** Sign up button. */
    private Button signUp;

    /** New Email from sign up. */
    private String newEmail;

    /** New Password from sign up. */
    private String newPassword;

    /** New Username from sign up. */
    private String newUsername;

    /** All registered emails. */
    private ArrayList<String> emails;

    /** All registered usernames. */
    private ArrayList<String> usernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Initialize Firebase Auth.
        mAuth = FirebaseAuth.getInstance();

        emails = new ArrayList<>();
        usernames = new ArrayList<>();

        email = findViewById(R.id.logInEmail);
        password = findViewById(R.id.logInPassword);
        logIn = findViewById(R.id.logIn);
        signUp = findViewById(R.id.logInSignUp);

        Intent intent = new Intent(this, SignUpActivity.class);
        intent.putExtra("emails", emails);
        intent.putExtra("usernames", usernames);

        signUp.setOnClickListener(unused -> startActivityForResult(intent, 8888));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 8888) {
            if (resultCode == Activity.RESULT_OK) {
                newEmail = data.getStringExtra("newEmail");
                newPassword = data.getStringExtra("newPassword");
                newUsername = data.getStringExtra("newUsername");

                emails.add(newEmail);
                usernames.add(newUsername);
            }
        }
    }
}
