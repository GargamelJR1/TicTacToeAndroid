package com.gargameljr.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SetupGameActivity extends AppCompatActivity {

    Button playSingleButton, playMultiButton;
    ConstraintLayout SingleplayerLayout, MultiplayerLayout;
    EditText playerName, player1Name, player2Name;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_game);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.setup_game));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        bindLayoutsToVariables();
        bindButtonToVariables();
        bindRadioGroupToVariable();
        bindEditTextstoVariables();
        setButtonsOnClickListeners();
        setRadioGroupOnClickListener();
    }

    private void bindRadioGroupToVariable() {
        radioGroup = findViewById(R.id.gameModeGroup);
    }

    private void setRadioGroupOnClickListener() {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.singlePlayerRaBtn) {
                {
                    SingleplayerLayout.setVisibility(ConstraintLayout.VISIBLE);
                    SingleplayerLayout.setClickable(true);
                    MultiplayerLayout.setVisibility(ConstraintLayout.GONE);
                    MultiplayerLayout.setClickable(false);
                }
            }
            else if (checkedId == R.id.multiPlayerRaBtn) {
                {
                    SingleplayerLayout.setVisibility(ConstraintLayout.GONE);
                    SingleplayerLayout.setClickable(false);
                    MultiplayerLayout.setVisibility(ConstraintLayout.VISIBLE);
                    MultiplayerLayout.setClickable(true);
                }
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void setButtonsOnClickListeners() {
        playSingleButton.setOnClickListener(v -> launchSinglePlayerGame());
        playMultiButton.setOnClickListener(v -> launchMultiPlayerGame());
    }

    private void launchMultiPlayerGame() {
        Intent intent = new Intent(this, GameMultiplayerActivity.class);
        intent.putExtra("player1Name", player1Name.getText().toString());
        intent.putExtra("player2Name", player2Name.getText().toString());
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    private void launchSinglePlayerGame() {
        Intent intent = new Intent(this, GameSingleplayerActivity.class);
        intent.putExtra("playerName", playerName.getText().toString());
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    private void bindLayoutsToVariables() {
        SingleplayerLayout = findViewById(R.id.singlePlayerLayout);
        MultiplayerLayout = findViewById(R.id.multiPlayerLayout);
    }

    private void bindButtonToVariables() {
        playSingleButton = SingleplayerLayout.findViewById(R.id.playSingleButton);
        playMultiButton = MultiplayerLayout.findViewById(R.id.playMultiButton);
    }

    private void bindEditTextstoVariables() {
        playerName = SingleplayerLayout.findViewById(R.id.playerNameEdit);
        player1Name = MultiplayerLayout.findViewById(R.id.player1NameEdit);
        player2Name = MultiplayerLayout.findViewById(R.id.player2NameEdit);
    }
}