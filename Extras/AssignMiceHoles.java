/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Assign Mice Holes (GFG  , Easy)

Assign Mice Holes
Difficulty: EasyAccuracy: 55.93%Submissions: 19K+Points: 2
You are given two arrays mices[] and holes[] of the same size. The array mices[] represents the positions of the mice on a straight line, while the array holes[] represents the positions of the holes on the same line. Each hole can accommodate exactly one mouse. A mouse can either stay in its current position, move one step to the right, or move one step to the left, and each move takes one minute. The task is to assign each mouse to a distinct hole in such a way that the time taken by the last mouse to reach its hole is minimized.

Examples:

Input: mices[] = [4, -4, 2], holes[] = [4, 0, 5] 
Output: 4
Explanation: Assign the mouse at position 4 to the hole at position 4, so the time taken is 0 minutes. Assign the mouse at position −4 to the hole at position 0, so the time taken is 4 minutes. Assign the mouse at position 2 to the hole at position 5, so the time taken is 3 minutes. Hence, the maximum time required by any mouse is 4 minutes.

Input: mices[] = [1, 2], holes[] = [20, 10] 
Output: 18 
Explanation: Assign the mouse at position 1 to the hole at position 10, so the time taken is 9 minutes. Assign the mouse at position 2 to the hole at position 20, so the time taken is 18 minutes. Hence, the maximum time required by any mouse is 18 minutes.

Constraints:
1 ≤ mices.size() = holes.size() ≤ 105
-105 ≤ mices[i] , holes[i] ≤ 105

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
The idea is to sort both arrays and then greedily assign each mouse to the corresponding hole in order. This ensures that every mouse is matched to its nearest possible hole, and the maximum time taken by any mouse is minimized.

Steps to solve the problem:

Sort both arrays mices and holes.
For each index i (0 to n−1), compute the absolute difference |mices[i] − holes[i]|.
Keep track of the maximum difference encountered so far.
That maximum value is the final answer.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/assign-mice-holes/
*/

class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // code here
         Arrays.sort(mices);
        Arrays.sort(holes);

        int n = mices.length;

        /* finding max difference between ith mice and hole */
        int max = 0;
        for (int i = 0; i <n; i++)
            if (max < Math.abs(mices[i] - holes[i]))
                max = Math.abs(mices[i] - holes[i]);

        return Math.abs(max);
    }
};