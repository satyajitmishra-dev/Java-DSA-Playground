/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.

Example:
Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
Output: false
Explanation: 62 is not present in the matrix, so output is false.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
The idea is to remove a row or column in each comparison until an element is found. Start searching from the top-right corner of the matrix. There are 3 possible cases:

x is greater than the current element: This ensures that all the elements in the current row are smaller than the given number as the pointer is already at the right-most element and the row is sorted. Thus, the entire row gets eliminated and continues the search from the next row.
x is smaller than the current element: This ensures that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continues the search from the previous column, i.e. the column on the immediate left.
The given number is equal to the current number: This will end the search.

This is a common search in a sorted 2D matrix problem. You should start from:

i = 0 (first row)
j = m - 1 (last column)

Then:
If mat[i][j] == x, return true.
If mat[i][j] > x, go left → j--
If mat[i][j] < x, go down → i++

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/article/MTEzMzc%3D

 */

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int row = mat.length, col = mat[0].length;
        
        int i = 0, j = col - 1;
        
        
        while(i < row && j >= 0){
            if(mat[i][j] == x) return true;
            else if(mat[i][j] > x) j--;
            else i++;
        }
        return false;
    }
}