/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
3446. Sort Matrix by Diagonals
// Problem Statement:  

// Difficulty Level : Medium(Leetcode)


You are given an n x n square matrix of integers grid. Return the matrix such that:

The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
The diagonals in the top-right triangle are sorted in non-decreasing order.
 

Example 1:

Input: grid = [[1,7,3],[9,8,2],[4,5,6]]

Output: [[8,2,3],[9,6,7],[4,5,1]]

Explanation:

The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:

[1, 8, 6] becomes [8, 6, 1].
[9, 5] and [4] remain unchanged.
The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:

[7, 2] becomes [2, 7].
[3] remains unchanged.
Example 2:

Input: grid = [[0,1],[1,2]]

Output: [[2,1],[1,0]]

Explanation:
The diagonals with a black arrow must be non-increasing, so [0, 2] is changed to [2, 0]. The other diagonals are already in the correct order.

Example 3:

Input: grid = [[1]]
Output: [[1]]
Explanation:
Diagonals with exactly one element are already in order, so no changes are needed.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
Step 1: Grouping Numbers by Diagonal
The first step is to iterate through the grid and populate a hashmap where the key is the diagonal ID (i−j) and the value is a list of all elements on that diagonal.

Let's use the example grid = [[1,7,3],[9,8,2],[4,5,6]]:

For element 1 at (0, 0), the diagonal ID is 0−0=0. The hashmap will store diag[0] = [1].

For element 7 at (0, 1), the diagonal ID is 0−1=−1. The hashmap will store diag[-1] = [7].

For element 3 at (0, 2), the diagonal ID is 0−2=−2. The hashmap will store diag[-2] = [3].

For element 9 at (1, 0), the diagonal ID is 1−0=1. The hashmap will store diag[1] = [9].

For element 8 at (1, 1), the diagonal ID is 1−1=0. The hashmap will now have diag[0] = [1, 8].

For element 2 at (1, 2), the diagonal ID is 1−2=−1. The hashmap will now have diag[-1] = [7, 2].

For element 4 at (2, 0), the diagonal ID is 2−0=2. The hashmap will store diag[2] = [4].

For element 5 at (2, 1), the diagonal ID is 2−1=1. The hashmap will now have diag[1] = [9, 5].

For element 6 at (2, 2), the diagonal ID is 2−2=0. The hashmap will now have diag[0] = [1, 8, 6].

After iterating through the entire grid, the hashmap will be:

diag[0] = [1, 8, 6]

diag[-1] = [7, 2]

diag[-2] = [3]

diag[1] = [9, 5]

diag[2] = [4]

Step 2: Sorting Each Diagonal
Next, you need to sort the elements in each list within the hashmap based on the diagonal ID.

Bottom-left and Main Diagonals (i−j≥0): Sort in non-increasing (descending) order.

diag[0] becomes [8, 6, 1]

diag[1] becomes [9, 5]

diag[2] becomes [4]

Top-right Diagonals (i−j<0): Sort in non-decreasing (ascending) order.

diag[-1] becomes [2, 7]

diag[-2] becomes [3]

Step 3: Writing Back into the Matrix
Finally, you'll create a new grid or modify the existing one. Iterate through the grid again, from (0, 0) to (n-1, n-1). For each cell (i, j), determine its diagonal ID (i−j), retrieve the next element from the sorted list corresponding to that ID, and place it into the cell. To keep track of the current position in each sorted list, you can use a separate index for each diagonal in the hashmap.

Let's continue with the example:

Start at (0, 0). The diagonal ID is 0. Take the first element from the sorted diag[0] list, which is 8. The grid becomes [[8, 7, 3], [9, 8, 2], [4, 5, 6]].

Move to (0, 1). The diagonal ID is −1. Take the first element from the sorted diag[-1] list, which is 2. The grid becomes [[8, 2, 3], [9, 8, 2], [4, 5, 6]].

Move to (0, 2). The diagonal ID is −2. Take the first element from the sorted diag[-2] list, which is 3. The grid becomes [[8, 2, 3], [9, 8, 2], [4, 5, 6]].

Move to (1, 0). The diagonal ID is 1. Take the first element from the sorted diag[1] list, which is 9. The grid becomes [[8, 2, 3], [9, 8, 2], [4, 5, 6]].

Move to (1, 1). The diagonal ID is 0. Take the next element from the sorted diag[0] list, which is 6. The grid becomes [[8, 2, 3], [9, 6, 2], [4, 5, 6]].

Move to (1, 2). The diagonal ID is −1. Take the next element from the sorted diag[-1] list, which is 7. The grid becomes [[8, 2, 3], [9, 6, 7], [4, 5, 6]].

Move to (2, 0). The diagonal ID is 2. Take the first element from the sorted diag[2] list, which is 4. The grid becomes [[8, 2, 3], [9, 6, 7], [4, 5, 6]].

Move to (2, 1). The diagonal ID is 1. Take the next element from the sorted diag[1] list, which is 5. The grid becomes [[8, 2, 3], [9, 6, 7], [4, 5, 5]].

Move to (2, 2). The diagonal ID is 0. Take the next element from the sorted diag[0] list, which is 1. The grid becomes [[8, 2, 3], [9, 6, 7], [4, 5, 1]].


🌐 Resource (ctrl + click) :: Help Of chatGpt & Leetcode solutions


*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        // The outer loop `t` is meant to perform multiple passes, but this
        // bubble sort-like approach is inefficient and likely won't fully sort the diagonals.
        for (int t = 0; t < n; t++){
            for (int i = 0; i < n - 1; i++){
                for (int j = 0; j < n - 1; j++){
                    // The condition `j > i` does not correctly differentiate between
                    // top-right and bottom-left diagonals. The correct condition
                    // is based on the diagonal ID: `i - j`.
                    if (j > i){
                        // This block should sort top-right diagonals (i-j < 0) in ascending order.
                        // However, `j > i` is not a reliable check, and the swap logic is flawed.
                        // Also, `grid[i][j]` and `grid[i+1][j+1]` are on the same diagonal.
                        if (grid[i][j] > grid[i + 1][j + 1]){
                            int tmp = grid[i][j];
                            grid[i][j] = grid[i + 1][j + 1];
                            grid[i + 1][j + 1] = tmp;
                        }
                    } else {
                        // This block should sort bottom-left diagonals (i-j >= 0) in descending order.
                        // The condition `j <= i` is also not a correct check for these diagonals.
                        // The comparison is also reversed, as it sorts in ascending order
                        // for `j <= i` which are typically bottom-left diagonals.
                        if (grid[i][j] < grid[i + 1][j + 1]){
                            int tmp = grid[i][j];
                            grid[i][j] = grid[i + 1][j + 1];
                            grid[i + 1][j + 1] = tmp;
                        }
                    }
                }
            }
        }
        return grid;
    }
}

// Time Complexity: O(n^3) due to the nested loops and the multiple passes.
// Space Complexity: O(1) as it sorts the matrix in place without using extra space