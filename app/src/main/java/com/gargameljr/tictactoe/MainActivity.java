package com.gargameljr.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button playButton, aboutButton, settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindButtonsToVariables();
        setButtonsOnClickListeners();
    }

    private void setButtonsOnClickListeners() {
        playButton.setOnClickListener(v -> launchGame());
        settingsButton.setOnClickListener(v -> OpenSettings());
        aboutButton.setOnClickListener(v -> openAbout());
    }

    private void bindButtonsToVariables() {
        playButton = findViewById(R.id.playBtn);
        settingsButton = findViewById(R.id.settingsBtn);
        aboutButton = findViewById(R.id.aboutBtn);
    }

    private void launchGame() {
        Intent intent = new Intent(this, SetupGameActivity.class);
        startActivity(intent);
    }

    private void OpenSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void openAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}