/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

Example :
Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
Output: true
Explanation: 9 is present in the matrix, so the output is true.

++++++++++++++++++++++++++++++++  APPROACH  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
You are given a matrix where every row is sorted in ascending order, but there is no guarantee about column sorting. The goal: Check if a given number (x) exists in the matrix.

Use Binary Search in Each Row
Each row is sorted, so binary search is the most efficient way to look for x in a row.

Binary search works by repeatedly dividing the search interval in half:

Check the middle element.
If it is x: Return true (found).
If it is greater than x: Search the left half.
If it is less than x: Search the right half.
Repeat the Check for Every Row

Since only rows are sorted and not columns, x could theoretically exist in any row.
For each row:
Perform binary search on the row.
If found, immediately return true (no need to check other rows).
Return False if Not Found in Any Row

If you've checked all rows and didn't find x, return false.

```Time Complexity

You perform a binary search on each row.
If the matrix has n rows and m columns, each binary search takes O(log m) time.

Total time: O(n × log m).

Why is this Efficient?
Naive Method: Without using binary search, you'd have to check every element, taking O(n × m) time.

This Approach: Since binary search is much faster than linear scan, your code is considerably more efficient for large matrices.

Typical Use Case Example
Suppose you have:

// Example matrix and target value
int[][] mat = {
    {1, 4, 7},
    {2, 5, 8},
    {3, 6, 9}
};
int x = 5;
Start with the first row: {1, 4, 7}. Binary search says 5 is not here.

Second row: {2, 5, 8}. Binary search finds 5!
Return true.

If x is not present in any row, return false.

In simple terms:
You efficiently check each row using binary search, leveraging the fact that each row is sorted. If x is in the matrix, you find it quickly. If not, you check all rows and then report it's missing.


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/article/MTI5MzA2OA%3D%3D

 */



class Solution {
    public boolean search(int[] arr,int target){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length;
        for(int i = 0; i < n ; i++){
            if(search(mat[i], x)) return true;
        }
      return false;
    }
}
