
import java.util.Scanner;

public class N_queen {

    static int N;

    // Check whether queen can be placed
    static boolean isSafe(int board[][], int row, int col) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Solve using backtracking
    static boolean solve(int board[][], int row) {

        if (row == N)
            return true;

        for (int col = 0; col < N; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1;

                if (solve(board, row + 1))
                    return true;

                // Backtracking
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        N = sc.nextInt();

        int board[][] = new int[N][N];

        // Place first queen in first row
        board[0][0] = 1;

        if (solve(board, 1)) {

            System.out.println("N-Queens Solution:");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("No solution exists");
        }

        sc.close();
    }
}







































































































/*
THEORY:

The N-Queens problem is a famous problem in computer science
in which we have to place N Queens on an N x N chessboard
so that no two Queens attack each other.

A Queen can attack horizontally, vertically and diagonally.
Therefore, no two Queens should be placed in the same row,
same column or same diagonal.

1. Backtracking:

Backtracking is an algorithmic technique used to solve problems
by trying different possible solutions. If a selected position
does not lead to a valid solution, the algorithm goes back
and tries another position.

2. Working:
- Create an N x N chessboard.
- Place the first Queen at the given position.
- Start placing the remaining Queens row by row.
- Check whether the selected position is safe.
- If the position is safe, place the Queen.
- Move to the next row.
- If no safe position is available, remove the previously
  placed Queen and try another column.
- Repeat until all N Queens are placed.
- Display the final chessboard matrix.

3. Safe Position:

Before placing a Queen, check three conditions:

- Same Column: No other Queen should be in the same column.
- Left Diagonal: No Queen should be present in the upper-left
  diagonal.
- Right Diagonal: No Queen should be present in the upper-right
  diagonal.

4. Example:

For a 4 x 4 chessboard, one valid solution is:

0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0

Here:
1 represents a Queen.
0 represents an empty position.

No two Queens attack each other.

5. Backtracking Process:

If a Queen cannot be placed safely in the current row,
the algorithm goes back to the previous row, removes the
previous Queen and tries another position.

This process continues until a valid solution is found.

6. Time Complexity:
O(N!) upper bound for the usual row-by-row backtracking
approach.

7. Space Complexity:
O(N^2) for storing the chessboard matrix.
Recursive calls require O(N) additional stack space.

8. Applications:
- Chessboard problems.
- Puzzle solving.
- Constraint satisfaction problems.
- Scheduling problems.
- Combinatorial optimization.

Conclusion:
The N-Queens problem is solved using the Backtracking technique.
It places Queens one by one while checking safe positions.
If a position is not valid, the algorithm goes back and tries
another position until a valid solution is generated.
*/
