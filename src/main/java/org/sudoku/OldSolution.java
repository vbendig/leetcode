package org.sudoku;

import java.util.Arrays;

class OldSolution {

    private static char [][] extremeDifficulty1 = {
            {'.','.','.','6','8','.','.','.','4'},
            {'8','.','2','.','.','3','.','5','9'},
            {'.','7','.','.','.','.','.','.','.'},
            {'.','.','6','.','4','.','7','.','.'},
            {'7','5','.','.','.','.','.','4','1'},
            {'.','.','.','.','2','.','.','.','.'},
            {'.','.','.','.','.','.','.','9','.'},
            {'.','1','.','8','.','.','4','.','6'},
            {'3','2','.','.','5','6','.','.','.'}};

    public static void main(String [] args) {
        OldSolution oldSolution = new OldSolution();
        oldSolution.solveSudoku(extremeDifficulty1);
        System.out.println(oldSolution.printSudoku(extremeDifficulty1));

    }

    public String printSudoku(char[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row: matrix) {
            stringBuilder.append(Arrays.toString(row) + '\n');
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int r, int c) {
        if (r == board.length) {
            return true;
        }
        if (c == board[0].length) {
            return solve(board, r + 1, 0);
        }
        if (board[r][c] != '.') {
            return solve(board, r, c + 1);
        }
        for (int i = 0; i < 9; ++i) {
            char cand = (char) ('1' + i);
            if (canSet(board, r, c, cand)) {
                board[r][c] = cand;
                if (solve(board, r, c + 1)) {
                    return true;
                }
                board[r][c] = '.';
            }
        }
        return false;
    }

    private boolean canSet(char[][] board, int r, int c, char cand) {
        for (int i = 0; i < 9; ++i) {
            if (board[r][i] == cand || board[i][c] == cand) {
                return false;
            }
        }
        int startRow = 3 * (r / 3);
        int startCol = 3 * (c / 3);
        for (int i = startRow; i < startRow + 3; ++i) {
            for (int j = startCol; j < startCol + 3; ++j) {
                if (board[i][j] == cand) {
                    return false;
                }
            }
        }
        return true;
    }
}