package com.gargameljr.tictactoelogic;

import java.util.Arrays;
import java.util.Random;

public class TicTacToeLogic {
    private final static int MAX_MOVES_NUMBER = 9;
    private final char[][] board = new char[3][3];
    private int lastMoveX, lastMoveY;
    private int moveCounter = 0;
    private int[][] winPositions = null;

    public TicTacToeLogic() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }

    public void makeMove(int x, int y, char symbol) {
        board[x][y] = symbol;
        lastMoveX = x;
        lastMoveY = y;
        moveCounter++;
    }

    public void undoMove(int x, int y) {
        board[x][y] = ' ';
        moveCounter--;
    }

    public int[][] getWinPositions() {
        return winPositions;
    }

    public int getLastMoveX() {
        return lastMoveX;
    }

    public int getLastMoveY() {
        return lastMoveY;
    }

    private boolean checkWin(char symbol) {
        if (lastMoveX == 0) {
            if (lastMoveY == 0) {
                if (board[0][1] == symbol && board[0][2] == symbol) {
                    winPositions = new int[][]{{0, 0}, {0, 1}, {0, 2}};
                    return true;
                }
                else if (board[1][0] == symbol && board[2][0] == symbol) {
                    winPositions = new int[][]{{0, 0}, {1, 0}, {2, 0}};
                    return true;
                }
                else if (board[1][1] == symbol && board[2][2] == symbol) {
                    winPositions = new int[][]{{0, 0}, {1, 1}, {2, 2}};
                    return true;
                }
            }
            else if (lastMoveY == 1) {
                if (board[0][0] == symbol && board[0][2] == symbol) {
                    winPositions = new int[][]{{0, 0}, {0, 1}, {0, 2}};
                    return true;
                }
                else if (board[1][1] == symbol && board[2][1] == symbol) {
                    winPositions = new int[][]{{0, 1}, {1, 1}, {2, 1}};
                    return true;
                }
            }
            else if (lastMoveY == 2) {
                if (board[0][0] == symbol && board[0][1] == symbol) {
                    winPositions = new int[][]{{0, 0}, {0, 1}, {0, 2}};
                    return true;
                }
                else if (board[1][2] == symbol && board[2][2] == symbol) {
                    winPositions = new int[][]{{0, 2}, {1, 2}, {2, 2}};
                    return true;
                }
                else if (board[1][1] == symbol && board[2][0] == symbol) {
                    winPositions = new int[][]{{0, 2}, {1, 1}, {2, 0}};
                    return true;
                }
            }
        }
        else if (lastMoveX == 1) {
            if (lastMoveY == 0) {
                if (board[1][1] == symbol && board[1][2] == symbol) {
                    winPositions = new int[][]{{1, 0}, {1, 1}, {1, 2}};
                    return true;
                }
                else if (board[0][0] == symbol && board[2][0] == symbol) {
                    winPositions = new int[][]{{0, 0}, {1, 0}, {2, 0}};
                    return true;
                }
            }
            else if (lastMoveY == 1) {
                if (board[0][1] == symbol && board[2][1] == symbol) {
                    winPositions = new int[][]{{0, 1}, {1, 1}, {2, 1}};
                    return true;
                }
                else if (board[1][0] == symbol && board[1][2] == symbol) {
                    winPositions = new int[][]{{1, 0}, {1, 1}, {1, 2}};
                    return true;
                }
                else if (board[0][0] == symbol && board[2][2] == symbol) {
                    winPositions = new int[][]{{0, 0}, {1, 1}, {2, 2}};
                    return true;
                }
                else if (board[0][2] == symbol && board[2][0] == symbol) {
                    winPositions = new int[][]{{0, 2}, {1, 1}, {2, 0}};
                    return true;
                }
            }
            else if (lastMoveY == 2) {
                if (board[1][0] == symbol && board[1][1] == symbol) {
                    winPositions = new int[][]{{1, 0}, {1, 1}, {1, 2}};
                    return true;
                }
                else if (board[0][2] == symbol && board[2][2] == symbol) {
                    winPositions = new int[][]{{0, 2}, {1, 2}, {2, 2}};
                    return true;
                }
            }
        }
        else if (lastMoveX == 2) {
            if (lastMoveY == 0) {
                if (board[0][0] == symbol && board[1][0] == symbol) {
                    winPositions = new int[][]{{0, 0}, {1, 0}, {2, 0}};
                    return true;
                }
                else if (board[2][1] == symbol && board[2][2] == symbol) {
                    winPositions = new int[][]{{2, 0}, {2, 1}, {2, 2}};
                    return true;
                }
                else if (board[1][1] == symbol && board[0][2] == symbol) {
                    winPositions = new int[][]{{2, 0}, {1, 1}, {0, 2}};
                    return true;
                }

            }
            else if (lastMoveY == 1) {
                if (board[2][0] == symbol && board[2][2] == symbol) {
                    winPositions = new int[][]{{2, 0}, {2, 1}, {2, 2}};
                    return true;
                }
                else if (board[0][1] == symbol && board[1][1] == symbol) {
                    winPositions = new int[][]{{0, 1}, {1, 1}, {2, 1}};
                    return true;
                }
            }
            else if (lastMoveY == 2) {
                if (board[0][2] == symbol && board[1][2] == symbol) {
                    winPositions = new int[][]{{0, 2}, {1, 2}, {2, 2}};
                    return true;
                }
                else if (board[2][0] == symbol && board[2][1] == symbol) {
                    winPositions = new int[][]{{2, 0}, {2, 1}, {2, 2}};
                    return true;
                }
                else if (board[0][0] == symbol && board[1][1] == symbol) {
                    winPositions = new int[][]{{0, 0}, {1, 1}, {2, 2}};
                    return true;
                }
            }
        }
        return false;
    }

    public char checkResult() {
        char result = ' ';
        if (board[lastMoveX][lastMoveY] == 'X') {
            if (checkWin('X')) result = 'X';
        }
        else if (board[lastMoveX][lastMoveY] == 'O') {
            if (checkWin('O')) result = 'O';
        }
        if (moveCounter == MAX_MOVES_NUMBER && result == ' ') result = 'D';
        return result;
    }

    public void resetGame() {
        initializeBoard();
        moveCounter = 0;
    }

    public class TicTacToeAI {
        private static final int MAX_DEPTH = 9;
        private final float difficulty;
        private final Random random = new Random();
        private TicTacToeLogic outer;


        public TicTacToeAI(float difficulty) {
            this.difficulty = difficulty;
        }

        public void makeMove(char symbol) {
            double randomDouble = random.nextDouble();
            outer = TicTacToeLogic.this;
            if (randomDouble >= difficulty) {
                makeRandomMove(symbol);
            }
            else {
                makeSmartMove(symbol);
            }
        }

        private void makeRandomMove(char symbol) {
            boolean moveMade = false;
            int counter = 0;

            do {
                int cordX = random.nextInt(3);
                int cordY = random.nextInt(3);
                if (outer.board[cordX][cordY] == ' ') {
                    outer.makeMove(cordX, cordY, symbol);
                    moveMade = true;
                }
                counter++;
            } while (!moveMade && counter < 9);

            if (!moveMade) {
                for (int i = 0; i < outer.board.length; i++) {
                    for (int j = 0; j < outer.board[i].length; j++) {
                        if (outer.board[i][j] == ' ') outer.makeMove(i, j, symbol);
                    }
                }
            }
        }

        private void makeSmartMove(char symbol) {
            int bestX = -1;
            int bestY = -1;
            int alpha = Integer.MIN_VALUE;
            int beta = Integer.MAX_VALUE;

            int bestMoveScore = symbol == 'X' ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < outer.board.length; i++) {
                for (int j = 0; j < outer.board[i].length; j++) {
                    if (outer.board[i][j] == ' ') {
                        outer.makeMove(i, j, symbol);
                        if (symbol == 'X') {
                            int moveScore = minMax(0, false, alpha, beta);
                            outer.undoMove(i, j);
                            if (moveScore > bestMoveScore) {
                                bestMoveScore = moveScore;
                                bestX = i;
                                bestY = j;
                                alpha = moveScore;
                            }
                        }
                        else {
                            int moveScore = minMax(0, true, alpha, beta);
                            outer.undoMove(i, j);
                            if (moveScore < bestMoveScore) {
                                bestMoveScore = moveScore;
                                bestX = i;
                                bestY = j;
                                beta = moveScore;
                            }
                        }
                    }
                }
            }
            outer.makeMove(bestX, bestY, symbol);
        }

        private int minMax(int depth, boolean isMaximizing, int alpha, int beta) {

            if (checkResult() == 'X') return (MAX_DEPTH - depth);
            else if (checkResult() == 'O') return -(MAX_DEPTH - depth);
            else if (checkResult() == 'D') return 0;

            int bestScore;
            if (isMaximizing) bestScore = Integer.MIN_VALUE;
            else bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < outer.board.length; i++) {
                for (int j = 0; j < outer.board[i].length; j++) {
                    if (outer.board[i][j] == ' ') {
                        outer.makeMove(i, j, isMaximizing ? 'X' : 'O');
                        int currentScore = minMax(depth + 1, !isMaximizing, alpha, beta);
                        outer.undoMove(i, j);
                        if (isMaximizing) {
                            bestScore = Math.max(bestScore, currentScore);
                            alpha = Math.max(alpha, bestScore);
                        }
                        else {
                            bestScore = Math.min(bestScore, currentScore);
                            beta = Math.min(beta, bestScore);
                        }
                        if (beta <= alpha)
                            return bestScore;
                    }
                }
            }
            return bestScore;
        }
    }
}
