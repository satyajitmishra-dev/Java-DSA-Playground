/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example :
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

++++++++++++++++++++++++++++++++  APPROACH  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Optimizing Space Using First Row and First Column (with zeroColumn Flag)
Instead of using additional arrays to track rows and columns to be zeroed, we use the first row and first column of the matrix itself as markers to save space.

However, the problem arises with the shared cell matrix, which would represent both the first row and the first column, causing ambiguity. To solve this, your solution uses:

A boolean zeroColumn to indicate whether the first column needs to be zeroed (independent of matrix).

A boolean zeroRow to indicate whether the first row needs to be zeroed (tracked by scanning the first row, reflected indirectly by matrix).

Step-by-step Explanation:
Initialize flags:

Scan the first row. If any cell is zero, set zeroRow = true.

Scan the first column. If any cell is zero, set zeroColumn = true.

Mark the first cells of the rows and columns:

Traverse the matrix from (1,1) to (m-1,n-1).
If a cell (i,j) is zero:

Mark the start of the row: matrix[i] = 0.

Mark the start of the column: matrix[j] = 0.

This way, the first row and first column act as markers for which rows and columns need to be zeroed.

Modify the inner matrix (1,1) to (m-1,n-1) based on markers:

For each cell (i, j) from (1,1) onwards:

If either matrix[i] == 0 (row is marked) or matrix[j] == 0 (column is marked),

Set matrix[i][j] = 0.

Note: Do not modify the first row and first column yet, as they hold critical marker information.

Finally update the first row and first column:

If zeroRow is true, set all cells in the first row to zero.

If zeroColumn is true, set all cells in the first column to zero.

Why do we process like this?
We leave the first row and first column unchanged during the inner matrix update (step 3), because they contain markers to decide which rows and columns to zero.

Changing the first row or column too early would alter those markers and cause incorrect zeroing (some columns or rows might be zeroed incorrectly).

The flag zeroColumn is needed because matrix is shared between row and column markers. Since this cell is already used for the first row markers, the first column zero status is tracked separately with zeroColumn.

The order of zeroing first row before first column also matters.
If we zeroed the first column first, it might modify matrix and thereby cause wrong updates for the first row.


🌐 Resource (ctrl + click) :: https://takeuforward.org/data-structure/set-matrix-zero/
🌐 Resource (ctrl + click) :: https://leetcode.com/problems/set-matrix-zeroes/
 */

class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean zeroRow = false; // Will track if the first row needs to be zeroed
        int col0 = 1;    // Instead of boolean zeroColumn, use integer col0 to track first column status

        // Check if any element in the first row is zero
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 0) {
                zeroRow = true;
                break;
            }
        }

        // Check if any element in the first column is zero
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 0) {
                col0 = 0; // Mark that the first column needs to be zeroed later
                break;
            }
        }

        // Use the first row and column as markers for which rows & columns to zero out
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) {
                    mat[0][j] = 0; // Mark column
                    mat[i][0] = 0; // Mark row
                }
            }
        }

        // Update the cells except first row/column based on these markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Zero out the first row if necessary
        if (zeroRow) {
            for (int j = 0; j < n; j++) {
                mat[0][j] = 0;
            }
        }

        // Zero out the first column if necessary (use col0)
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
