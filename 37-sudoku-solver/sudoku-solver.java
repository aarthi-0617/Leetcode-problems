class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (board[row][col] == '.') {
                    // Try numbers 1-9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;

                            // Recurse to see if this leads to a solution
                            if (solve(board)) {
                                return true;
                            } else {
                                // Backtrack: undo the choice
                                board[row][col] = '.';
                            }
                        }
                    }
                    // If no number 1-9 works, this path is dead
                    return false;
                }
            }
        }
        return true; // Board is full and valid
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[i][col] == c) return false;
            // Check column
            if (board[row][i] == c) return false;
            // Check 3x3 sub-grid
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
}
