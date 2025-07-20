/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 

Example:
Input: mat[][] = [[0, 1, 2], 
                [3, 4, 5], 
                [6, 7, 8]] 

Output:         [[2, 5, 8],
                [1, 4, 7],
                [0, 3, 6]]

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++
otating a square matrix 90 degrees counterclockwise, each element moves to a new position. The top row becomes the left most column in reverse order, the second row becomes the second-left most column in reverse order, and so on. By first reversing the rows, you rearrange the elements in such a way that when you transpose them, they end up in their final rotated positions.

Follow the given steps to solve the problem:

Reverse every individual row of the matrix
Perform Transpose of the matrix
Note: We can also rotate the matrix by first performing the transpose and then reversing every column of the matrix.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/article/MTM3ODgx

 */