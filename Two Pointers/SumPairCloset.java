/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Sum Pair Closest to Target

Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a ≤ b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: As 5 + 20 = 25 is closest to 25.

Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. 

Input: arr[] = [10], target = 10
Output: []
Explanation: As the input array has only 1 element, return an empty array.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to sort the array and use Two Pointer Technique to find the pair with sum closest to target. Initialize a pointer left to the beginning of the array and another pointer right to the end of the array. Now, compare the sum at both the pointers to find the pair sum closest to target:

If arr[left] + arr[right] < target: We need to increase the pair sum, so move left to higher value.
If arr[left] + arr[right] > target: We need to decrease the pair sum, so move right to smaller value.
If arr[left] + arr[right] == target: We have found a pair with sum = target, so we can return the pair.
Note: In this approach, we don't need to separately handle the case when there is a tie between pairs and we need to select the one with maximum absolute difference. This is because we are selecting the first element of the pair in increasing order, so if we have a tie between two pairs, we can always choose the first pair.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/article/MTMxMjg2Mg%3D%3D

*/

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer> ans = new ArrayList<>();
        if(arr.length == 1) return ans;
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            if(Math.abs(target - sum) < minDiff){
                minDiff = Math.abs(target - sum);
                ans = Arrays.asList(arr[left], arr[right]);
            } if(sum < target){
                left++;
            } else if(sum > target){
                right--;
            } else return ans;
        }
        return ans;
    }
}