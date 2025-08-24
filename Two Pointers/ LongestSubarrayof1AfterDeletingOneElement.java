/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement:  Longest Subarray of 1's After Deleting One Element
// Difficulty Level : Medium(leetcode - 1493)

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

Intuition
The problem asks for the longest subarray of 1s after deleting exactly one element.

Key insight:

We can allow at most one 0 to exist in the current window while maximizing the length of consecutive 1s.

If a second 0 appears, we shrink the window from the left until there’s only one 0 in the window. This is a classic sliding window / two-pointer technique.

Approach
Use two pointers:
left → start of the window.
right → current position iterating through nums.
Maintain:
count0 → number of zeros in the window (should be ≤ 1).
first_0_idx → index of the most recent 0.
For each right:
If nums[right] == 1 → expand the window normally.
If nums[right] == 0:
If count0 == 0, include this 0 and store its index.
If count0 == 1, shift left to one position after the previous zero to maintain only one zero in the window.
Update ans as the window length minus one (since we must delete one element).

Return the result.

Complexity
Time complexity: Each index is visited at most twice (once by right and once by left) → O(n)
Space complexity: Only variables for tracking → O(1)

🌐 Resource (ctrl + click) :: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/submissions/1746698983



*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

class Solution {
    public int longestSubarray(int[] nums) {
        int count1 = 0, count0 = 0, ans = 0;
        int left = 0, first_0_idx = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1 && count0 <= 1) {
                count1++;
            } else if (nums[right] == 0 && count0 == 0) {
                count0++;
                first_0_idx = right;
            } else if (nums[right] == 0 && count0 == 1) {
                count1 = right - first_0_idx - 1;
                count0 = 1;
                left = first_0_idx + 1;
                first_0_idx = right;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans - 1;
    }
}

