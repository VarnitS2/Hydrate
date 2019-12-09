package com.example.hydrate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView email = findViewById(R.id.signUpEmail);
        TextView password = findViewById(R.id.signUpPassword);
        TextView username = findViewById(R.id.username);
        Button signUp = findViewById(R.id.signUpSignUp);

        signUp.setOnClickListener(unused -> {
            String newEmail = email.getText().toString();
            String newPassword = password.getText().toString();
            String newUsername = username.getText().toString();

            Intent intent = getIntent();
            ArrayList<String> emails = intent.getStringArrayListExtra("emails");
            ArrayList<String> usernames = intent.getStringArrayListExtra("usernames");

            if (newEmail.isEmpty() || newPassword.isEmpty() || newUsername.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Empty fields")
                        .setMessage("Please ensure all fields are filled.")
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Log.i("AD_BUTTON_PRESS", "Close pressed");
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            } else if (emails.contains(newEmail)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Email already exists")
                        .setMessage("An account with this email already exists, please log in if you have already registered. Otherwise, use a different email.")
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Log.i("AD_BUTTON_PRESS", "Close pressed");
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            } else if (usernames.contains(newUsername)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Username already exists")
                        .setMessage("An account with this username already exists, please use a different username.")
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Log.i("AD_BUTTON_PRESS", "Close pressed");
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newEmail", newEmail);
                resultIntent.putExtra("newPassword", newPassword);
                resultIntent.putExtra("newUsername", newUsername);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
