/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Indexes of Subarray with Given Sum

Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].

Examples:

Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.

Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.

Input: arr[] = [5, 3, 4], target = 2
Output: [-1]
Explanation: There is no subarray with sum 2.



++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is simple, as we know that all the elements in subarray are positive so, If a subarray has sum greater than the given sum then there is no possibility that adding elements to the current subarray will be equal to the given sum. So the Idea is to use a similar approach to a sliding window. 

Start with an empty window 
add elements to the window while the current sum is less than sum 
If the sum is greater than sum, remove elements from the start of the current window.
If current sum becomes same as sum, return the result

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/article/MTkyNjc%3D

*/

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int sum = 0;
        int s = 0, e = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            
            if(sum >= target){
                e = i;
                
                while(sum > target && s < e){
                    sum -= arr[s];
                    ++s;
                }
                if(sum == target){
                    ans.add(s + 1);
                    ans.add(e + 1);
                    return ans;
                }
            }
        }
            ans.add(-1);
            return ans;
    }
}
