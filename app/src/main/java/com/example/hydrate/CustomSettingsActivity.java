package com.example.hydrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
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
    private ConstraintLayout innerLayout;

    /** The preferences radio group. */
    private RadioGroup preferencesList;

    /** The distance radio button. */
    private RadioButton distance;

    /** The quality radio button. */
    private RadioButton quality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_settings);

        logIn = findViewById(R.id.logInButton);
        logOut = findViewById(R.id.logOutButton);
        innerLayout = findViewById(R.id.innerLayout);
        preferencesList = innerLayout.findViewById(R.id.preferencesList);
        distance = preferencesList.findViewById(R.id.distanceButton);
        quality = preferencesList.findViewById(R.id.qualityButton);

        username = LogInDataHolder.USERNAME;
        emails = LogInDataHolder.EMAILS;
        passwords = LogInDataHolder.PASSWORDS;
        usernames = LogInDataHolder.USERNAMES;
        loginFlag = LogInDataHolder.LOGINFLAG;

        if (LogInDataHolder.buttonID == R.id.distanceButton) {
            distance.setChecked(true);
        } else if (LogInDataHolder.buttonID == R.id.qualityButton) {
            quality.setChecked(true);
        }

        if (loginFlag) {
            logIn.setVisibility(View.GONE);
            logOut.setVisibility(View.VISIBLE);
        } else {
            logOut.setVisibility(View.GONE);
            logIn.setVisibility(View.VISIBLE);
        }

        preferencesList.setOnCheckedChangeListener((group, checkedId) -> LogInDataHolder.buttonID = checkedId);

        logOut.setOnClickListener(unused -> {
            Toast.makeText(this, "Successfully logged out of " + username, Toast.LENGTH_LONG).show();
            LogInDataHolder.LOGINFLAG = false;
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

                LogInDataHolder.USERNAME = username;
                LogInDataHolder.EMAILS = emails;
                LogInDataHolder.PASSWORDS = passwords;
                LogInDataHolder.USERNAMES = usernames;
                LogInDataHolder.LOGINFLAG = loginFlag;
            }
        }
    }

    public int getCheckedButton() {
        int checkedButton = preferencesList.getCheckedRadioButtonId();
        if (checkedButton == R.id.distanceButton) {
            return 0;
        } else if (checkedButton == R.id.qualityButton){
            return 1;
        } else {
            return -1;
        }
    }
}
