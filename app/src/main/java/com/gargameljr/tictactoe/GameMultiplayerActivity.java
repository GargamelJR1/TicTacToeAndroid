package com.gargameljr.tictactoe;

import android.os.Bundle;

public final class GameMultiplayerActivity extends GameAbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPlayersNames();
    }

    @Override
    protected void setContinueButtonOnClickListener() {
        continueButton.setOnClickListener(v -> {
            resetBoard();
            disableControlButtons();
            updateSymbols();
        });
    }

    @Override
    protected void setButtonsOnClickListeners() {
        for (int i = 0; i < buttons.length; i++) {
            int finalI = i;
            for (int j = 0; j < buttons[i].length; j++) {
                int finalJ = j;
                buttons[i][j].setOnClickListener(v -> {
                    texts[finalI][finalJ].setText(String.valueOf(currentPlayerChar));
                    buttons[finalI][finalJ].setClickable(false);
                    gameLogic.makeMove(finalI, finalJ, currentPlayerChar);
                    if (!checkGameFinish()) {
                        if (currentPlayerChar == 'X') {
                            currentPlayerSymbolText.setText("O");
                            currentPlayerChar = 'O';
                        }
                        else {
                            currentPlayerSymbolText.setText("X");
                            currentPlayerChar = 'X';
                        }
                    }
                });
            }
        }
    }

    @Override
    protected void bindCurrentPlayerSymbolTextToVariable() {
        currentPlayerSymbolText = findViewById(R.id.currentPlayerSymbolText);
    }

    public void setPlayersNames() {
        String player1NameString = getIntent().getStringExtra("player1Name");
        String player2NameString = getIntent().getStringExtra("player2Name");
        if (player1NameString != null && !player1NameString.isEmpty())
            player1Name.setText(getIntent().getStringExtra("player1Name"));
        if (player2NameString != null && !player2NameString.isEmpty())
            player2Name.setText(getIntent().getStringExtra("player2Name"));
    }

    protected void updateSymbols() {
        currentPlayerChar = 'X';
        currentPlayerSymbolText.setText("X");
        super.updateSymbols();
    }
}