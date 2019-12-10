package com.example.hydrate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

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

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

            Preference logInButton = findPreference(getString(R.string.log_in));
            Preference logOutButton = findPreference(getString(R.string.log_out));
            ListPreference priorityMeasurements = findPreference(getString(R.string.priority_measurements));

            if (loginFlag) {
                logInButton.setVisible(false);
                logOutButton.setVisible(true);
            } else {
                logInButton.setVisible(true);
                logOutButton.setVisible(false);
            }

            logOutButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Toast.makeText(getContext(), "Successfully logged out", Toast.LENGTH_LONG).show();
                    loginFlag = false;
                    logOutButton.setVisible(false);
                    logInButton.setVisible(true);
                    return true;
                }
            });

            logInButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(getContext(), LogInActivity.class);
                    intent.putExtra("emails", emails);
                    intent.putExtra("passwords", passwords);
                    intent.putExtra("usernames", usernames);
                    startActivityForResult(intent, 4444);

                    logInButton.setVisible(false);
                    logOutButton.setVisible(true);
                    return true;
                }
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

                    Toast.makeText(getContext(), "Welcome " + username + "!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
