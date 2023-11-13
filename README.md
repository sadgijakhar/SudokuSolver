# SudokuSolver

It contains five functions

* SolveSudoku(int[][] board):
  ```
    This is the main function responsible for solving the Sudoku puzzle using a recursive backtracking approach. It starts by finding an empty cell, and then it tries placing numbers from 1 to 9 in the empty cell, checking if the move is valid. If a valid move is found, it recursively calls itself to solve the rest of the puzzle. If a solution is not found, it backtracks and explores other possibilities.
  ```
  
* findEmptyCell(int[][] board):
  ```
    This function is used to find the first empty cell in the Sudoku grid. It iterates through the rows and columns, returning the indices of the first empty cell encountered as an array of two integers representing the row and column.
  ```
  
* isValidMove(int[][] board, int row, int col, int num):
  ```
    Checks whether placing a specific number (num) in a given cell (row, col) is a valid move. It checks if the number is not present in the same row, column, or 3x3 subgrid. Returns true if the move is valid, and false otherwise.
  ```
  
* printBoard(int[][] board):
  ```
    Prints the current state of the Sudoku board. It iterates through each row and column, printing the numbers in a grid format. This function is primarily used for debugging and displaying the solved puzzle.
  ```
  
* main(String[] args):
  ```
    The main method serves as an entry point to the program. It initializes a Sudoku puzzle, calls the solveSudoku method to solve it, and then prints the solution if one exists. If no solution is found, it prints a message indicating that no solution exists.
  ```

## Sudoku Solver - How It Works
This Sudoku Solver is implemented using a backtracking algorithm, a commonly used approach for solving Sudoku puzzles. The following steps outline the functionality of the program:

### Start:
- The program begins its execution.
  
### Finding Empty Cells:
- The solver starts with the first empty cell in the Sudoku grid.
  
### Generating Valid Values:
- A list of possible valid values that can be placed in the current empty cell is generated.
  
### Iterative Placement:
- The program iterates over the list of valid values and attempts to place the first value in the current cell.
  
### Backtracking on Invalid Values:
- If placing a value in the current cell leads to an invalid configuration (e.g., violates Sudoku rules), the algorithm backtracks.
- It moves back to the previous cell and tries the next value from the list of possibilities.
- This process continues until a valid value is found for the current cell.
  
### Completing the Puzzle:
- The program repeats steps 3-5 for each subsequent empty cell in the grid.
- The solving process stops when the 81st cell (the last cell in a Sudoku puzzle) is filled with a valid value.
  
### Puzzle Solved:
- At this point, the Sudoku puzzle has been successfully solved.
  
### Stop:
- The program concludes its execution.
