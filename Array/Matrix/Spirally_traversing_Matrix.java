/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.

Example:
Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

Imagine you have a grid of numbers (a 2D matrix) and you want to read them all, not row by row, but by spiraling inwards, like unwinding a coil. That's what spiral traversal is all about!

The Core Idea: Shrinking Boundaries
We'll use four "walls" (boundaries) to control our movement:

top: The topmost row we haven't visited yet.

bottom: The bottommost row we haven't visited yet.

left: The leftmost column we haven't visited yet.

right: The rightmost column we haven't visited yet.

We'll repeatedly move along these walls, collecting numbers, and then shrink the walls inward. We continue this until our top crosses bottom or our left crosses right, meaning we've visited all numbers.

Step-by-Step Approach
Let's walk through an example with a 3
times4 matrix:

$$\begin{bmatrix} 1 & 2 & 3 & 4 \\ 10 & 11 & 12 & 5 \\ 9 & 8 & 7 & 6 \end{bmatrix} $$1. **Initialization:** * `result = []` (This list will store our numbers in spiral order) * `rows = 3`, `cols = 4` * `top = 0` (First row index) * `bottom = 2` (Last row index: `rows - 1`) * `left = 0` (First column index) * `right = 3` (Last column index: `cols - 1`) **Loop Condition:** `while (top <= bottom && left <= right)` 2. **Phase 1: Move Right (Across the Top Row)** * Start at `(top, left)` and go to `(top, right)`. * Add `mat[top][i]` for `i` from `left` to `right`. * Numbers collected: `[1, 2, 3, 4]` * **Action:** We've processed the `top` row. So, move `top` boundary down: `top++` (now `top = 1`). Current Matrix (visited `1,2,3,4`): $$
$$\\begin{bmatrix}
\\underline{1} & \\underline{2} & \\underline{3} & \\underline{4} \\
10 & 11 & 12 & 5 \\
9 & 8 & 7 & 6
\\end{bmatrix}

$$
$$Boundaries: `top=1, bottom=2, left=0, right=3`
Phase 2: Move Down (Along the Rightmost Column)

Start at (top, right) and go to (bottom, right).

Add mat[i][right] for i from top to bottom.

Numbers collected: [1, 2, 3, 4, 5, 6]

Action: We've processed the right column. So, move right boundary left: right-- (now right = 2).

Current Matrix (visited 5,6):

$$$$$$\\begin{bmatrix} 1 & 2 & 3 & \\underline{4} \\ 10 & 11 & 12 & \\underline{5} \\ 9 & 8 & 7 & \\underline{6} \\end{bmatrix} $$
$$$$Boundaries: top=1, bottom=2, left=0, right=2

Phase 3: Move Left (Across the Bottom Row)

Crucial Check: Only do this if top <= bottom. (This handles cases where we might have just a single row left).

Start at (bottom, right) and go to (bottom, left).

Add mat[bottom][i] for i from right down to left.

Numbers collected: [1, 2, 3, 4, 5, 6, 7, 8, 9]

Action: We've processed the bottom row. So, move bottom boundary up: bottom-- (now bottom = 1).

Current Matrix (visited 7,8,9):

$$$$$$\\begin{bmatrix} 1 & 2 & 3 & 4 \\ 10 & 11 & 12 & 5 \\ \\underline{9} & \\underline{8} & \\underline{7} & 6 \\end{bmatrix} $$
$$$$Boundaries: top=1, bottom=1, left=0, right=2

Phase 4: Move Up (Along the Leftmost Column)

Crucial Check: Only do this if left <= right. (This handles cases where we might have just a single column left).

Start at (bottom, left) and go to (top, left).

Add mat[i][left] for i from bottom down to top.

Numbers collected: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Action: We've processed the left column. So, move left boundary right: left++ (now left = 1).

Current Matrix (visited 10):

$$$$$$\\begin{bmatrix} 1 & 2 & 3 & 4 \\ \\underline{10} & 11 & 12 & 5 \\ 9 & 8 & 7 & 6 \\end{bmatrix} $$
$$$$Boundaries: top=1, bottom=1, left=1, right=2

Repeat (Inner Spiral):

Loop Condition: while (top <= bottom && left <= right) is (1 <= 1 && 1 <= 2), which is true. So, we continue.

Phase 1 (Move Right):

i from left=1 to right=2.

Add mat[top=1][i]: mat[1][1] (11), mat[1][2] (12)

Numbers collected: [..., 11, 12]

top++ (now top = 2)

Current Matrix (visited 11,12):

$$$$$$\\begin{bmatrix} 1 & 2 & 3 & 4 \\ 10 & \\underline{11} & \\underline{12} & 5 \\ 9 & 8 & 7 & 6 \\end{bmatrix} $$
$$$$Boundaries: top=2, bottom=1, left=1, right=2

Loop Termination:

Loop Condition: while (top <= bottom && left <= right) is (2 <= 1 && 1 <= 2). The first part (2 <= 1) is false.

The loop terminates. All elements are collected!

Why the if conditions for Phase 3 and 4? 🤔
Imagine a 1
times5 matrix:
[1, 2, 3, 4, 5]

Right: [1, 2, 3, 4, 5]. top becomes 1.

Down: Loop doesn't run (top is 1, bottom is 0, top <= bottom is false). right becomes 3.

Left (if top <= bottom): top is 1, bottom is 0. Condition 1 <= 0 is false. This if prevents trying to traverse a non-existent bottom row, or double-counting 1,2,3,4,5 if bottom was top and we traversed it again.

Up (if left <= right): This also wouldn't run.

These if checks prevent issues when the matrix shrinks to a single row or single column, ensuring elements aren't skipped or double-counted.

🌐 Resource (ctrl + click) ::https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/article/MTA3Njg%3D

 */

class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> ans =  new ArrayList<Integer>();
        if(mat.length == 0) return ans;
        int rows = mat.length, column = mat[0].length;
        
        int top = 0, left = 0, right = column - 1, bottom = rows - 1;
        
        while(left <= right && top <= bottom){
            
            for(int i = left; i <= right; i++){
                ans.add(mat[top][i]);
            }
            top += 1;
            
            for(int j = top ; j <= bottom; j++){
                ans.add(mat[j][right]);
            }
            right--;
            if(top <= bottom){
              for(int i = right; i >= left; i--){
                  ans.add(mat[bottom][i]);
              }
              bottom--;
              
              if(left <= right){
                  for(int j = bottom ; j >= top; j--){
                      ans.add(mat[j][left]);
                  }
                  left++;
              }
            }
        }
        
        return ans;
    }
}
