/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Minimum Jumps (GFG  , Medium)

You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

For example:

If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
If arr[i] = 0, you cannot jump forward from that position.
Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

Note:  Return -1 if you can't reach the end of the array.

Examples : 

Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
Output: 3 
Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. 

Input: arr = [1, 4, 3, 2, 6, 7]
Output: 2 
Explanation: First we jump from the 1st to 2nd element and then jump to the last element.

Input: arr = [0, 10, 20]
Output: -1
Explanation: We cannot go anywhere from the 1st element.

Constraints:
2 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
The idea is to greedily keep track of the farthest index you can reach say(maxReach) as you move along. You don’t jump at every step — instead, you move within the current jump’s range and only when that range ends, you take a jump and extend it to maxReach. This way we can find the minimum number of jumps, since every jump is stretched to its farthest possible reach.

To implement this, we just maintain a few variables while iterating:

jumps → number of jumps taken so far
currentEnd → end of the current jump range
maxReach → farthest index reachable so far
At each index, update maxReach = max(maxReach, i + arr[i]).
If you reach currentEnd, increment jumps and extend currentEnd = maxReach.
If at any point i == currentEnd but maxReach == currentEnd, it means we cannot reach to the end, return -1.



🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/minimum-number-jumps-reach-endset-2on-solution/
*/

class Solution {
    public int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        if (arr[0] == 0)
            return -1;
        int maxReach = 0;
        int currReach = 0;
        int jump = 0;
        for (int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);

            if (maxReach >= n - 1) {
                return jump + 1;
            }

            // Increment the Jump as we reached the
            // Current Reachable index
            if (i == currReach) {

                // If Max reach is same as current index
                // then we can not jump further
                if (i == maxReach) {
                    return -1;
                }

                // If Max reach > current index then
                // increment jump and update current
                // reachable index
                else {
                    jump++;
                    currReach = maxReach;
                }
            }
        }

        return -1;
    }
}