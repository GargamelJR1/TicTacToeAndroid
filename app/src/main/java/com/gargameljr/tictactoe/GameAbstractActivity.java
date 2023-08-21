package com.gargameljr.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gargameljr.tictactoelogic.TicTacToeLogic;

public abstract class GameAbstractActivity extends AppCompatActivity {
    protected final ImageButton[][] buttons = new ImageButton[3][3];
    protected final TextView[][] texts = new TextView[3][3];
    protected final TicTacToeLogic gameLogic = new TicTacToeLogic();
    protected TextView currentPlayerSymbolText;
    protected TextView player1Name, player2Name;
    protected TextView scorePlayer1Text, scorePlayer2Text;
    protected char currentPlayerChar = 'X';
    protected boolean Player1SymbolIsX = true;
    protected Button exitButton, continueButton;
    protected TextView player1CurrentSymbolText, player2CurrentSymbolText;

    abstract protected void setContinueButtonOnClickListener();

    abstract protected void setButtonsOnClickListeners();

    abstract protected void bindCurrentPlayerSymbolTextToVariable();

    protected void updateSymbols() {
        Player1SymbolIsX = !Player1SymbolIsX;
        if (Player1SymbolIsX) {
            player1CurrentSymbolText.setText("X");
            player2CurrentSymbolText.setText("O");
        }
        else {
            player1CurrentSymbolText.setText("O");
            player2CurrentSymbolText.setText("X");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        bindButtonsToVariables();
        bindTextsToVariables();
        bindCurrentPlayerSymbolTextToVariable();
        bindPlayerScoreTextsToVariables();
        bindPlayerNameToVariables();
        bindControlButtonsToVariables();
        setControlButtonsOnClickListeners();
        bindPlayerCurrentSymbolsTextsToVariables();
        setButtonsOnClickListeners();
    }

    private void updateResult(char result) {
        if (Player1SymbolIsX) {
            if (result == 'X') {
                scorePlayer1Text.setText(String.valueOf(Integer.parseInt(scorePlayer1Text.getText().toString()) + 1));
            }
            else if (result == 'O') {
                scorePlayer2Text.setText(String.valueOf(Integer.parseInt(scorePlayer2Text.getText().toString()) + 1));
            }
        }
        else {
            if (result == 'O') {
                scorePlayer1Text.setText(String.valueOf(Integer.parseInt(scorePlayer1Text.getText().toString()) + 1));
            }
            else if (result == 'X') {
                scorePlayer2Text.setText(String.valueOf(Integer.parseInt(scorePlayer2Text.getText().toString()) + 1));
            }
        }
    }

    private void enableContinueButton() {
        continueButton.setEnabled(true);
    }

    protected boolean checkGameFinish() {
        char result = gameLogic.checkResult();
        if (result != ' ') {
            updateResult(result);
            showResultToast(result);
            disableButtons();
            enableContinueButton();
            if (result != 'D')
                setWinningButtonsBackground(gameLogic.getWinPositions());
            return true;
        }
        return false;
    }

    private void setWinningButtonsBackground(int[][] winningButtons) {
        for (int[] winningButton : winningButtons) {
            buttons[winningButton[0]][winningButton[1]].setColorFilter(Color.BLACK);
        }
    }

    private void disableButtons() {
        for (ImageButton[] buttonsRow : buttons)
            for (ImageButton button : buttonsRow) button.setClickable(false);
    }

    private void showResultToast(char result) {
        int winner; // 1 is player 1, -1 is player 2, 0 is draw
        if (result == 'X') {
            winner = -1;
        }
        else if (result == 'O') {
            winner = 1;
        }
        else
            winner = 0;

        if (Player1SymbolIsX)
            winner = -winner;

        if (winner == 1)
            Toast.makeText(this, player1Name.getText().toString() + " " + getString(R.string.won), Toast.LENGTH_SHORT).show();
        else if (winner == -1)
            Toast.makeText(this, player2Name.getText().toString() + " " + getString(R.string.won), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, getString(R.string.draw), Toast.LENGTH_SHORT).show();
    }

    protected void resetBoard() {
        for (int i = 0; i < buttons.length; i++)
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setClickable(true);
                buttons[i][j].setColorFilter(null);
                texts[i][j].setText("");
            }
        gameLogic.resetGame();
    }

    private void setControlButtonsOnClickListeners() {
        setContinueButtonOnClickListener();
        setExitButtonOnClickListener();
    }

    protected void persistMove(int x, int y, char symbol) {
        texts[x][y].setText(String.valueOf(symbol));
        buttons[x][y].setClickable(false);
    }

    private void setExitButtonOnClickListener() {
        exitButton.setOnClickListener(v -> finish());
    }

    protected void disableControlButtons() {
        continueButton.setEnabled(false);
    }

    private void bindPlayerCurrentSymbolsTextsToVariables() {
        player1CurrentSymbolText = findViewById(R.id.player1CurrentSymbol);
        player2CurrentSymbolText = findViewById(R.id.player2CurrentSymbol);
    }

    private void bindControlButtonsToVariables() {
        exitButton = findViewById(R.id.exitBtn);
        continueButton = findViewById(R.id.continueBtn);
    }

    private void bindPlayerNameToVariables() {
        player1Name = findViewById(R.id.player1Text);
        player2Name = findViewById(R.id.player2Text);
    }

    private void bindPlayerScoreTextsToVariables() {
        scorePlayer1Text = findViewById(R.id.player1ScoreText);
        scorePlayer2Text = findViewById(R.id.player2ScoreText);
    }

    private void bindButtonsToVariables() {
        buttons[0][0] = findViewById(R.id.boardButton00);
        buttons[0][1] = findViewById(R.id.boardButton01);
        buttons[0][2] = findViewById(R.id.boardButton02);
        buttons[1][0] = findViewById(R.id.boardButton10);
        buttons[1][1] = findViewById(R.id.boardButton11);
        buttons[1][2] = findViewById(R.id.boardButton12);
        buttons[2][0] = findViewById(R.id.boardButton20);
        buttons[2][1] = findViewById(R.id.boardButton21);
        buttons[2][2] = findViewById(R.id.boardButton22);
    }

    private void bindTextsToVariables() {
        texts[0][0] = findViewById(R.id.boardText00);
        texts[0][1] = findViewById(R.id.boardText01);
        texts[0][2] = findViewById(R.id.boardText02);
        texts[1][0] = findViewById(R.id.boardText10);
        texts[1][1] = findViewById(R.id.boardText11);
        texts[1][2] = findViewById(R.id.boardText12);
        texts[2][0] = findViewById(R.id.boardText20);
        texts[2][1] = findViewById(R.id.boardText21);
        texts[2][2] = findViewById(R.id.boardText22);
    }
}