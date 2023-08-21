package com.gargameljr.tictactoe;

import static org.junit.Assert.assertEquals;

import com.gargameljr.tictactoelogic.TicTacToeLogic;

import org.junit.Test;

public class GameResultTest {

    @Test
    public void testGameXWin() {
        // X - -
        // - X -
        // - - X
        TicTacToeLogic gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'X');
        gameLogic.makeMove(1, 1, 'X');
        gameLogic.makeMove(2, 2, 'X');
        assertEquals('X', gameLogic.checkResult());

        // - - X
        // - X -
        // X - -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 2, 'X');
        gameLogic.makeMove(1, 1, 'X');
        gameLogic.makeMove(2, 0, 'X');
        assertEquals('X', gameLogic.checkResult());

        // X X X
        // - - -
        // - - -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'X');
        gameLogic.makeMove(0, 1, 'X');
        gameLogic.makeMove(0, 2, 'X');
        assertEquals('X', gameLogic.checkResult());

        // - - -
        // X X X
        // - - -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(1, 0, 'X');
        gameLogic.makeMove(1, 1, 'X');
        gameLogic.makeMove(1, 2, 'X');
        assertEquals('X', gameLogic.checkResult());

        // - - -
        // - - -
        // X X X
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(2, 0, 'X');
        gameLogic.makeMove(2, 1, 'X');
        gameLogic.makeMove(2, 2, 'X');
        assertEquals('X', gameLogic.checkResult());

        // X - -
        // X - -
        // X - -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'X');
        gameLogic.makeMove(1, 0, 'X');
        gameLogic.makeMove(2, 0, 'X');
        assertEquals('X', gameLogic.checkResult());

        // - X -
        // - X -
        // - X -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 1, 'X');
        gameLogic.makeMove(1, 1, 'X');
        gameLogic.makeMove(2, 1, 'X');
        assertEquals('X', gameLogic.checkResult());

        // - - X
        // - - X
        // - - X
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 2, 'X');
        gameLogic.makeMove(1, 2, 'X');
        gameLogic.makeMove(2, 2, 'X');
        assertEquals('X', gameLogic.checkResult());
    }

    @Test
    public void testGameOWin() {
        // O - -
        // - O -
        // - - O
        TicTacToeLogic gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'O');
        gameLogic.makeMove(1, 1, 'O');
        gameLogic.makeMove(2, 2, 'O');
        assertEquals('O', gameLogic.checkResult());

        // - - O
        // - O -
        // O - -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 2, 'O');
        gameLogic.makeMove(1, 1, 'O');
        gameLogic.makeMove(2, 0, 'O');
        assertEquals('O', gameLogic.checkResult());

        // O O O
        // - - -
        // - - -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'O');
        gameLogic.makeMove(0, 1, 'O');
        gameLogic.makeMove(0, 2, 'O');
        assertEquals('O', gameLogic.checkResult());

        // - - -
        // O O O
        // - - -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(1, 0, 'O');
        gameLogic.makeMove(1, 1, 'O');
        gameLogic.makeMove(1, 2, 'O');
        assertEquals('O', gameLogic.checkResult());

        // - - -
        // - - -
        // O O O
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(2, 0, 'O');
        gameLogic.makeMove(2, 1, 'O');
        gameLogic.makeMove(2, 2, 'O');
        assertEquals('O', gameLogic.checkResult());

        // O - -
        // O - -
        // O - -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'O');
        gameLogic.makeMove(1, 0, 'O');
        gameLogic.makeMove(2, 0, 'O');
        assertEquals('O', gameLogic.checkResult());

        // - O -
        // - O -
        // - O -
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 1, 'O');
        gameLogic.makeMove(1, 1, 'O');
        gameLogic.makeMove(2, 1, 'O');
        assertEquals('O', gameLogic.checkResult());

        // - - O
        // - - O
        // - - O
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 2, 'O');
        gameLogic.makeMove(1, 2, 'O');
        gameLogic.makeMove(2, 2, 'O');
        assertEquals('O', gameLogic.checkResult());
    }

    @Test
    public void testGameDraw() {
        // X O X
        // X O O
        // O X X
        TicTacToeLogic gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'X');
        gameLogic.makeMove(0, 1, 'O');
        gameLogic.makeMove(0, 2, 'X');
        gameLogic.makeMove(1, 0, 'X');
        gameLogic.makeMove(1, 1, 'O');
        gameLogic.makeMove(1, 2, 'O');
        gameLogic.makeMove(2, 0, 'O');
        gameLogic.makeMove(2, 1, 'X');
        gameLogic.makeMove(2, 2, 'X');
        assertEquals('D', gameLogic.checkResult());

        // O X O
        // X O X
        // X O X
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'O');
        gameLogic.makeMove(0, 1, 'X');
        gameLogic.makeMove(0, 2, 'O');
        gameLogic.makeMove(1, 0, 'X');
        gameLogic.makeMove(1, 1, 'O');
        gameLogic.makeMove(1, 2, 'X');
        gameLogic.makeMove(2, 0, 'X');
        gameLogic.makeMove(2, 1, 'O');
        gameLogic.makeMove(2, 2, 'X');
        assertEquals('D', gameLogic.checkResult());

        // X O X
        // X O O
        // O X X
        gameLogic = new TicTacToeLogic();
        gameLogic.makeMove(0, 0, 'X');
        gameLogic.makeMove(0, 1, 'O');
        gameLogic.makeMove(0, 2, 'X');
        gameLogic.makeMove(1, 0, 'X');
        gameLogic.makeMove(1, 1, 'O');
        gameLogic.makeMove(1, 2, 'O');
        gameLogic.makeMove(2, 0, 'O');
        gameLogic.makeMove(2, 1, 'X');
        gameLogic.makeMove(2, 2, 'X');
        assertEquals('D', gameLogic.checkResult());
    }
}