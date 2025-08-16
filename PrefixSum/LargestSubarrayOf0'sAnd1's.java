/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Largest subarray of 0's and 1's

Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

Examples:

Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.

Input: arr[] = [0, 0, 1, 1, 0]
Output: 4
Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.

Input: arr[] = [0]
Output: 0
Explnation: There is no subarray with an equal number of 0s and 1s.
++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
// Approach: Brute Force

// The brute force approach is to check all the subarrays of the given array and count the number of 0s and 1s in each subarray.
// If the count of 0s and 1s is equal, we will update the maximum length of the subarray found so far.  
// We will run two loops, one for the starting index and another for the ending index of the subarray.
// The time complexity of this approach is O(n^2) where n is the size of the array.
// Time Complexity: O(n^2)
// Space Complexity: O(1) - no extra space is used

// Approach: Prefix Sum & HashMap

If we consider every 0 as -1, then this problem become same as the longest subarray with 0 sum problem.

We traverse the array and compute the prefix sum

If current prefix sum == 0, it means that subarray from index (0) till present index has equal number of 0's and 1's.
If we encounter a prefix sum value which we have already encountered before, which means that subarray from the previous index+1 till the present index has equal number of 0's and 1's as they give a cumulative sum of 0.
In a nutshell this problem is equivalent to finding two indexes i & j in arr[], such that prefix sums till i and j are same, and (j - i) is maximum. To store the first occurrence of each unique cumulative sum value we use a hash map where if we get that value again we can find the subarray size and compare it with the maximum size found till now.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/largest-subarray-with-equal-number-of-0s-and-1s/
*/

// Prefix Sum & HashMap Approach

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int maxLength = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
         
            prefixSum += (arr[i] == 0) ? -1 : 1;
            if(prefixSum == 0) maxLength = i + 1;
            
            if(map.containsKey(prefixSum)){
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
                
            }
            else 
                map.put(prefixSum, i);
        }
        return maxLength;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n) - for storing prefix sums in the map
