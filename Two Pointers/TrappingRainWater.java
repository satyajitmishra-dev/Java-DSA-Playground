/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Trapping Rain Water

Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.
Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.
Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

For every element we first calculate and store the highest bar on the left and on the right (say stored in arrays left[] and right[]). 
Then iterate the array and use the calculated values to find the amount of water stored in this index, 
which is the same as ( min(left[i], right[i]) - arr[i] )

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/trapping-rain-water/
*/

class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        // Fill Left Array
        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        
        // Fill Right Array
        right[n-1] = arr[n-1];
        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        
        for(int i = 1; i < n-1; i++){
            int minOfTwo = Math.min(left[i], right[i]);
            ans += minOfTwo - arr[i];
        }
        return ans;
    }
}
