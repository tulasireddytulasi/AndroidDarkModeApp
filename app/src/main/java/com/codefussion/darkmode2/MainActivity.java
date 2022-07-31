package com.codefussion.darkmode2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private Boolean isDarkModeOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        isDarkModeOn = getDarkModeStatus();
        if (isDarkModeOn) {
            button.setText("On Light Mode");
        } else {
            button.setText("On Dark Mode");
        }

        button.setOnClickListener(view -> {
            if (isDarkModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                button.setText("On Light Mode");
                isDarkModeOn = false;
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                button.setText("On Dark Mode");
                isDarkModeOn = true;
            }
        });
    }


    private boolean getDarkModeStatus() {
        int nightMOdeFlag =
                MainActivity.this.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightMOdeFlag) {
            case Configuration.UI_MODE_NIGHT_YES:
                return true;
            case Configuration.UI_MODE_NIGHT_NO:
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                return false;
        }

        return false;

    }
}