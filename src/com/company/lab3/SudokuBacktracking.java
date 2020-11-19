package com.company.lab3;

public class SudokuBacktracking {

    public static boolean possible(int[][] board, int row, int col, int value) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }
        for (int j = 0; j < board.length; j++) {
            if (board[j][col] == value)
            {
                return false;
            }
        }

        int square = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % square;
        int boxColStart = col - col % square;

        for (int i = boxRowStart;
             i < boxRowStart + square; i++)
        {
            for (int j = boxColStart;
                 j < boxColStart + square; j++)
            {
                if (board[i][j] == value)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solve(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        if (isEmpty) {
            return true;
        }

        for (int value = 1; value <= n; value++)
        {
            if (possible(board, row, col, value))
            {
                board[row][col] = value;
                if (solve(board, n))
                {
                    return true;
                }
                else
                {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }

    public static void main(String[] args) {
        int [][] board = {
                {0, 0, 0, 8, 0, 4, 9, 3, 7},
                {0, 7, 4, 1, 0, 0, 0, 8, 0},
                {8, 3, 2, 0, 0, 0, 4, 0, 0},
                {2, 0, 5, 3, 0, 0, 7, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 6},
                {1, 4, 3, 0, 0, 0, 2, 0, 0},
                {0, 0, 7, 0, 9, 0, 6, 0, 0},
                {0, 2, 1, 7, 5, 6, 8, 9, 0},
                {6, 5, 9, 2, 3, 0, 0, 7, 4}};
        int N = board.length;

        if (solve(board, N))
        {
            print(board, N);
        }
        else {
            System.out.println("Finns ingen lösning");
        }
    }
}