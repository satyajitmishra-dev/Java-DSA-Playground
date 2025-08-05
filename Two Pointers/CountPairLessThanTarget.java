/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.

Examples:

Input: arr[] = [7, 2, 5, 3], target = 8
Output: 2
Explanation: There are 2 pairs with sum less than 8: (2, 5) and (2, 3). 

Input: arr[] = [5, 2, 3, 2, 4, 1], target = 5
Output: 4
Explanation: There are 4 pairs whose sum is less than 5: (2, 2), (2, 1), (3, 1) and (2, 1).

Input: arr[] = [2, 1, 8, 3, 4, 7, 6, 5], target = 7
Output: 6
Explanation: There are 6 pairs whose sum is less than 7: (2, 1), (2, 3), (2, 4), (1, 3), (1, 4) and (1, 5).


++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

First sort the array, then use Two Pointers Technique to find the number of pairs with a sum less than the given target. Initialize two pointers, one at the beginning (left) and the other at the end (right) of the array. Now, compare the sum of elements at these pointers with the target:

If sum < target:
Pairs formed by the element at the left pointer with every element between left and right (inclusive) will have a sum less than the target. Therefore, we add (right - left) to the count and move the left pointer one step to the right to explore more pairs.
If sum >= target:
We move the right pointer one step to the left to reduce the sum.


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/article/MTQxNTQz
 */

// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1, count = 0;
        
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum < target) {
                count+= j - i;
                i++;
            } else j--;
        }
        return count;
    }
}