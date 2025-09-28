/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPL++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Longest Bounded-Difference Subarray (GFG, Medium)

Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.

Examples:

Input: arr[] = [8, 4, 5, 6, 7], x = 3 
Output: [4, 5, 6, 7] 
Explanation: The sub-array described by index [1..4], i.e. [4, 5, 6, 7]

contains no two elements whose absolute differnce is greater than 3.
Input: arr[] = [1, 10, 12, 13, 14], x = 2 
Output: [12, 13, 14] 
Explanation: The sub-array described by index [2..4], i.e. [12, 13, 14]
contains no two elements whose absolute differnece is greater than 2.

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109
0 ≤ x ≤ 109

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
Initialize

Create two deques:
minQueue → to track the minimum element (in increasing order).
maxQueue → to track the maximum element (in decreasing order).

Set two pointers:
start = 0 (left side of window)
end = 0 (right side of window)
Store best window found so far:
resStart = 0, resEnd = 0
Expand window using end

While end < n
a. Remove larger elements from the end of minQueue (keep increasing order).
b. Remove smaller elements from the end of maxQueue (keep decreasing order).
c. Add the current index end into both queues.

Check validity of window
While the difference (arr[maxQueue.front] - arr[minQueue.front]) > x:
If start is at the front of minQueue, remove it.
If start is at the front of maxQueue, remove it.

Increase start by 1 (shrink window from left).
Update best answer
If current window (end - start) is longer than best so far:
Update resStart = start, resEnd = end.

Move forward

Increase end by 1 (expand window to the right).

Result
After the loop ends, collect elements from arr[resStart … resEnd] and return as the longest subarray.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/longest-subarray-in-which-absolute-difference-between-any-two-element-is-not-greater-than-x/#expected-approach-using-monotonic-queues-on-time-and-on-space
*/
class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        
        int n = arr.length, start = 0, end = 0;
        
        int resStart = 0, resEnd = 0;
        while (end < n) {
            
            // Pop the elements greater than current element
            // from min Queue
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();
                
            // Pop the elements smaller than current element
            // from max Queue
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();
                
            // Push the current index to both the queues
            minQueue.addLast(end);
            maxQueue.addLast(end);
            
            // Check if the subarray has maximum difference less
            // than x
            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                       
                // Reduce the length of sliding window by moving
                // the start pointer
                if (start == minQueue.peekFirst())
                    minQueue.pollFirst();
                if (start == maxQueue.peekFirst())
                    maxQueue.pollFirst();
                start += 1;
            }
            
            // Maximize the subarray length
            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
            end += 1;
        }

       
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++)
            res.add(arr[i]);
            
        return res;
    }
}

