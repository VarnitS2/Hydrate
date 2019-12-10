package com.example.hydrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomSettingsActivity extends AppCompatActivity {

    /** Username of current logged in user. */
    private String username;

    /** All registered emails. */
    private ArrayList<String> emails;

    /** All registered passwords. */
    private ArrayList<String> passwords;

    /** All registered usernames. */
    private ArrayList<String> usernames;

    /** Login flag check. */
    private boolean loginFlag;

    /** The log in button. */
    private Button logIn;

    /** The log out button. */
    private Button logOut;

    /** The inner layout. */
    private ConstraintLayout innerLayout = findViewById(R.id.innerLayout);

    /** The preferences radio group. */
    public RadioGroup preferencesList = innerLayout.findViewById(R.id.preferencesList);

    /** The distance radio button. */
    public RadioButton distance = preferencesList.findViewById(R.id.distanceButton);

    /** The quality radio button. */
    public RadioButton quality = preferencesList.findViewById(R.id.qualityButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_settings);

        logIn = findViewById(R.id.logInButton);
        logOut = findViewById(R.id.logOutButton);
        //innerLayout =
        //preferencesList
        //distance ;
        //quality = preferencesList.findViewById(R.id.qualityButton);

        if (loginFlag) {
            logIn.setVisibility(View.GONE);
            logOut.setVisibility(View.VISIBLE);
        } else {
            logOut.setVisibility(View.GONE);
            logIn.setVisibility(View.VISIBLE);
        }

        distance.setOnClickListener(unused -> {

        });

        logOut.setOnClickListener(unused -> {
            Toast.makeText(this, "Successfully logged out", Toast.LENGTH_LONG).show();
            loginFlag = false;
            logOut.setVisibility(View.GONE);
            logIn.setVisibility(View.VISIBLE);
        });

        logIn.setOnClickListener(unused -> {
            Intent intent = new Intent(this, LogInActivity.class);
            intent.putExtra("emails", emails);
            intent.putExtra("passwords", passwords);
            intent.putExtra("usernames", usernames);
            startActivityForResult(intent, 4444);

            logIn.setVisibility(View.GONE);
            logOut.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4444) {
            if (resultCode == Activity.RESULT_OK) {
                username = data.getStringExtra("username");
                emails = data.getStringArrayListExtra("emails");
                passwords = data.getStringArrayListExtra("passwords");
                usernames = data.getStringArrayListExtra("usernames");
                loginFlag = true;

                Toast.makeText(this, "Welcome " + username + "!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
