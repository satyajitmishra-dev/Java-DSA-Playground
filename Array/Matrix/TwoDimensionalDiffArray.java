/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
You are given a 2D integer matrix mat[][] of size n × m and a list of q operations opr[][]. Each operation is represented as an array [v, r1, c1, r2, c2], where:

v is the value to be added
(r1, c1) is the top-left cell of a submatrix
(r2, c2) is the bottom-right cell of the submatrix (inclusive)
For each of the q operations, add v to every element in the submatrix from (r1, c1) to (r2, c2). Return the final matrix after applying all operations.

Example:

Input: mat[][] = [[1, 2, 3],  opr[][] = [[2, 0, 0, 1, 1], [-1, 1, 0, 2, 2]]
                [1, 1, 0],
                [4,-2, 2]]
Output: [[3, 4, 3],
        [2, 2, -1],
        [3, -3, 1]] 


++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

Step By Step Implementations:

Create a diff[][] matrix of size n × m initialized with zeros. This matrix will store increment/decrement markers to indicate where the effect of v should begin or end.
For each query [v, r1, c1, r2, c2], perform the following 4 operations:
=> diff[r1][c1] += v;
=> diff[r1][c2 + 1] -= v; (if c1 + 1 is less than n)
=> diff[r2 + 1][c1] -= v; ( if r2 + 1 is less than m)
=> diff[r2 + 1][c2 + 1] += v; ( r2 + 1 is less than n and c1 + 1 is less than m )
Take row wise prefix sum i.e, for each i => diff[i][j] += diff[i][j-1]
Take column wise prefix sum i.e, for each j => diff[i][j] += diff[i-1][j]
Now apply the net updates from diff back to the original matrix (i.e., mat[i][j] += diff[i][j]).


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/two-dimensional-difference-array/
 */

import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] diff = new int[n][m];

        // Apply all operations
        for (int[] q : opr) {
            int v = q[0];
            int r1 = q[1], c1 = q[2], r2 = q[3], c2 = q[4];

            diff[r1][c1] += v;

            if (c2 + 1 < m) diff[r1][c2 + 1] -= v;
            if (r2 + 1 < n) diff[r2 + 1][c1] -= v;
            if (r2 + 1 < n && c2 + 1 < m) diff[r2 + 1][c2 + 1] += v;
        }

        // Row-wise prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // Column-wise prefix sum
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // Apply the difference matrix to the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] += diff[i][j];
            }
        }

        // Convert to ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(mat[i][j]);
            }
            result.add(row);
        }

        return result;
    }
}
