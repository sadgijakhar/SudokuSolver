public class SudokunSolver {
    // static int move = 1 ;

    public static boolean solveSudoku(int[][] board) {
        int[] emptyCell = findEmptyCell(board);

        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];
        

        for (int num = 1; num <= 9; num++) {
            if (isValidMove(board, row, col, num)) {
                // Try placing the number
                board[row][col] = num;
                // System.out.println(move);
                // printBoard(board);
                // move++;

                // Recursively try to solve the rest of the puzzle
                if (solveSudoku(board)) {
                    return true;
                }

                // If placing the number doesn't lead to a solution, backtrack
                board[row][col] = 0;
            }
        }

        // If no number can be placed, backtrack
        return false;
    }

    private static int[] findEmptyCell(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // No empty cells
    }

    private static boolean isValidMove(int[][] board, int row, int col, int num) {
        // Check if the number is not present in the same row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check if the number is not present in the 3x3 subgrid
        int subgridStartRow = row - row % 3;
        int subgridStartCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subgridStartRow + i][subgridStartCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] sudokuGrid = {
        //         {5, 3, 0, 0, 7, 0, 0, 0, 0},
        //         {6, 0, 0, 1, 9, 5, 0, 0, 0},
        //         {0, 9, 8, 0, 0, 0, 0, 6, 0},
        //         {8, 0, 0, 0, 6, 0, 0, 0, 3},
        //         {4, 0, 0, 8, 0, 3, 0, 0, 1},
        //         {7, 0, 0, 0, 2, 0, 0, 0, 6},
        //         {0, 6, 0, 0, 0, 0, 2, 8, 0},
        //         {0, 0, 0, 4, 1, 9, 0, 0, 5},
        //         {0, 0, 0, 0, 8, 0, 0, 7, 9}
        // };
        int[][] sudokuGrid = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };

        if (solveSudoku(sudokuGrid)) {
            System.out.println("Sudoku solved:");
            printBoard(sudokuGrid);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
