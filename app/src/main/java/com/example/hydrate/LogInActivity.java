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

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    /** All registered emails. */
    private ArrayList<String> emails;

    /** All registered passwords. */
    private ArrayList<String> passwords;

    /** All registered usernames. */
    private ArrayList<String> usernames;

    /** Map of all emails to passwords. */
    private Map<String, String> passwordCredentials;

    /** Map of all emails to usernames. */
    private Map<String, String> usernameCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        passwordCredentials = new HashMap<>();
        usernameCredentials = new HashMap<>();

        Intent gettingIntent = getIntent();
        ArrayList<String> receivedEmails = gettingIntent.getStringArrayListExtra("emails");
        ArrayList<String> receivedPasswords = gettingIntent.getStringArrayListExtra("passwords");
        ArrayList<String> receivedUsernames = gettingIntent.getStringArrayListExtra("usernames");

        if (receivedEmails == null) {
            emails = new ArrayList<>();
        } else {
            emails = receivedEmails;
        }

        if (receivedPasswords == null) {
            passwords = new ArrayList<>();
        } else {
            passwords = receivedPasswords;
        }

        if (receivedUsernames == null) {
            usernames = new ArrayList<>();
        } else {
            usernames = receivedUsernames;
        }

        for (int i = 0; i < emails.size(); i++) {
            passwordCredentials.put(emails.get(i), passwords.get(i));
            usernameCredentials.put(emails.get(i), usernames.get(i));
        }

        email = findViewById(R.id.logInEmail);
        password = findViewById(R.id.logInPassword);
        logIn = findViewById(R.id.logInButton);
        signUp = findViewById(R.id.logInSignUp);

        Intent intent = new Intent(this, SignUpActivity.class);
        intent.putExtra("emails", emails);
        intent.putExtra("usernames", usernames);

        signUp.setOnClickListener(unused -> startActivityForResult(intent, 8888));

        logIn.setOnClickListener(unused -> {
            String emailUsed = email.getText().toString();
            String passwordUsed = password.getText().toString();

            if (emailUsed.isEmpty() || passwordUsed.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Empty fields")
                        .setMessage("Please ensure all fields are filled.")
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Log.i("AD_BUTTON_PRESS", "Okay pressed");
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            } else if (passwordCredentials.containsKey(emailUsed)) {
                if (passwordCredentials.get(emailUsed).equals(passwordUsed)) {
                    String username = usernameCredentials.get(emailUsed);

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("username", username);
                    resultIntent.putExtra("emails", emails);
                    resultIntent.putExtra("passwords", passwords);
                    resultIntent.putExtra("usernames", usernames);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Incorrect password")
                            .setMessage("The password you used is incorrect, please try again.")
                            .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.i("AD_BUTTON_PRESS", "Okay pressed");
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Account does not exist")
                        .setMessage("An account with that email does not exist")
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Log.i("AD_BUTTON_PRESS", "Okay pressed");
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 8888) {
            if (resultCode == Activity.RESULT_OK) {
                String newEmail = data.getStringExtra("newEmail");
                String newPassword = data.getStringExtra("newPassword");
                String newUsername = data.getStringExtra("newUsername");

                emails.add(newEmail);
                passwords.add(newPassword);
                usernames.add(newUsername);

                passwordCredentials.put(newEmail, newPassword);
                usernameCredentials.put(newEmail, newUsername);
            }
        }
    }
}
