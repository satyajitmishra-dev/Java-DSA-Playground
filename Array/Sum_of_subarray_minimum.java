/* 

Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.

Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.

Examples:
Input: arr[] = [3, 1, 2, 4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3, 1], [1, 2], [2, 4], [3, 1, 2], [1, 2, 4], [3, 1, 2, 4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1. Sum of all these is 17.

*/

class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<int[]> s1 = new Stack<>();
        Stack<int[]> s2 = new Stack<>();

        // Count elements greater 
        // than arr[i] on the left
        for (int i = 0; i < n; i++) {
            
            // get elements from stack until element 
           // greater to arr[i] found
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > arr[i]) {
                count += s1.pop()[1];
            }
            s1.push(new int[]{arr[i], count});
            left[i] = count;
        }

        // Count elements greater than 
        // or equal to arr[i] on the right
        for (int i = n - 1; i >= 0; i--) {
            
            // get elements from stack until element 
            // greater or equal to arr[i] found
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= arr[i]) {
                count += s2.pop()[1];
            }
            s2.push(new int[]{arr[i], count});
            right[i] = count;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i] * left[i] * right[i];
        }

        return result;
    }
}
