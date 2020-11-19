package com.company.lab3;

public class Sudoku {
    static int N =9;
    /*
    TO-DO ett sätt att kontrollera att vi kan placera en siffra på given position
     */

    private static boolean possible(int[][] board, int row, int col, int value){
        //Kontroller rad och kolumn, om value finns i rad eller kolumn, return false
        for(int i = 0; i < 9; i++){
            if(board[row][i] == value || board[i][col] == value){
                return false;
            }
        }

        //Kontrollera aktuell 3x3 ruta
        int rowStart = row -row% 3;
        int colStart = col - col% 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i + rowStart][j+colStart] == value){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean solve(int[][] board, int row, int col) {
        if (row == N - 1 && col == N)
            return true;
        if (col == N) {
            row++;
            col = 0;
        }
        if (board[row][col] != 0)
            return solve(board, row, col + 1);
        for (int value = 1; value < 10; value++) {
            if (possible(board, row, col, value)) {
                board[row][col] = value;
                if (solve(board, row, col + 1))
                    return true;
            }
            board[row][col] = 0;
        }
        return false;
    }
        //Loopa igenom alla rader och kolumner (Två nästlade loopar)
        //  kolla om det är en nolla på den aktuella positionen
        //    Loopar vi igenom alla tal mellan 1 och 9
        //      Kolla, kan vi placera aktuellt tal på den aktuella positionen
        //        om ja, placerar vi aktuellt värde på positionen
        //          anropa solve
        //          ta bort det aktuella värdet
        //     return
        //Skriv ut lösningen
    private static void print(int[][] board){
        for(int i=0;i<N;i++){
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][] board = {{0, 0, 0, 8, 0, 4, 9, 3, 7},
                {0, 7, 4, 1, 0, 0, 0, 8, 0},
                {8, 3, 2, 0, 0, 0, 4, 0, 0},
                {2, 0, 5, 3, 0, 0, 7, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 6},
                {1, 4, 3, 0, 0, 0, 2, 0, 0},
                {0, 0, 7, 0, 9, 0, 6, 0, 0},
                {0, 2, 1, 7, 5, 6, 8, 9, 0},
                {6, 5, 9, 2, 3, 0, 0, 7, 4}};

        System.out.println("should be true " + possible(board, 4, 4, 2));
        System.out.println("should be false " + possible(board, 4, 4, 6));
        System.out.println("should be false " + possible(board, 4, 4, 5));
        System.out.println("should be false " + possible(board, 5, 4, 3));
        if(solve(board,0,0))
            print(board);
        else
            System.out.println("Det finns ingen lösning på denna sudoku");
    }
}
