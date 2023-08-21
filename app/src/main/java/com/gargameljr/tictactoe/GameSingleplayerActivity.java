package com.gargameljr.tictactoe;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.preference.PreferenceManager;

import com.gargameljr.tictactoelogic.TicTacToeLogic;

public final class GameSingleplayerActivity extends GameAbstractActivity {

    TextView currentPlayerText;
    TicTacToeLogic.TicTacToeAI ai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentPlayerText();
        setPlayerName();
        initializeAI();
    }


    @Override
    protected void setContinueButtonOnClickListener() {
        continueButton.setOnClickListener(v -> {
            resetBoard();
            disableControlButtons();
            updateSymbols();
            additionalAIMove();
        });
    }

    @Override
    protected void setButtonsOnClickListeners() {
        for (int i = 0; i < buttons.length; i++) {
            int finalI = i;
            for (int j = 0; j < buttons[i].length; j++) {
                int finalJ = j;
                buttons[i][j].setOnClickListener(v -> {
                    persistMove(finalI, finalJ, currentPlayerChar);
                    gameLogic.makeMove(finalI, finalJ, currentPlayerChar);
                    if (!checkGameFinish()) {
                        if (Player1SymbolIsX) {
                            ai.makeMove('O');
                            persistMove(gameLogic.getLastMoveX(), gameLogic.getLastMoveY(), 'O');
                        }
                        else {
                            ai.makeMove('X');
                            persistMove(gameLogic.getLastMoveX(), gameLogic.getLastMoveY(), 'X');
                        }
                        checkGameFinish();
                    }
                });
            }
        }
    }

    @Override
    protected void bindCurrentPlayerSymbolTextToVariable() {
        currentPlayerText = findViewById(R.id.currentPlayerText);
        currentPlayerSymbolText = findViewById(R.id.currentPlayerSymbolText);
    }

    private void setPlayerName() {
        String playerNameString = getIntent().getStringExtra("playerName");
        if (playerNameString != null && !playerNameString.isEmpty())
            player1Name.setText(getIntent().getStringExtra("playerName"));
    }

    private void initializeAI() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        float difficulty = Float.parseFloat(sharedPreferences.getString("difficultyListPreference", "0.5"));
        ai = gameLogic.new TicTacToeAI(difficulty);
    }

    private void setCurrentPlayerText() {
        currentPlayerText.setText(getString(R.string.your_symbol));
    }

    protected void updateSymbols() {
        if (currentPlayerChar == 'X') {
            currentPlayerSymbolText.setText("O");
            currentPlayerChar = 'O';
        }
        else if (currentPlayerChar == 'O') {
            currentPlayerSymbolText.setText("X");
            currentPlayerChar = 'X';
        }
        super.updateSymbols();
    }

    private void additionalAIMove() {
        if (!Player1SymbolIsX) {
            ai.makeMove('X');
            persistMove(gameLogic.getLastMoveX(), gameLogic.getLastMoveY(), 'X');
        }
    }
}