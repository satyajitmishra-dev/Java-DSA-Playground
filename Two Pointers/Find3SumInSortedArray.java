/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
Given a sorted array arr[] and a target value, the task is to find the count of triplets present in the given array having sum equal to the given target. 

More specifically, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2

Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1. 


++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to fix the first element of the triplet at index i and then using two pointers technique to count the other two elements. For each index i, initialize left pointer to i + 1 and right pointer to n - 1.

For each triplet, calculate the sum as arr[i] + arr[left] + arr[right] and evaluate:

If sum = target: A valid triplet is found. Additionally, handle duplicates by counting the frequencies of arr[left] and arr[right] and updating the result accordingly. Then move both pointers to the next distinct values.
If sum < target: Increment the left pointer to explore larger values and increase the sum.
If sum > target: Decrement the right pointer to explore smaller values and decrease the sum.


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/article/MTM1NDQ0Mw%3D%3D

 */

class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int count = 0;
        for(int i = 0; i < arr.length - 2; i++){
            int j = i + 1, k = arr.length - 1;
            
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target) {
                    if(arr[j] == arr[k]){
                        int len = k - j + 1;
                        count += (len * (len - 1))/2;
                        break;
                    }
                    int left = 1, right = 1;
                    
                    while(j + 1 < k && arr[j] == arr[j + 1]){
                        j++;
                        left++;
                    }
                    while(k - 1 > j && arr[k] == arr[k - 1]){
                       right++;
                       k--;
                    }
                    count += left * right;
                    j++;
                    k--;
                }
                else if(sum < target) {
                   j++;
                }
                else k--;
            }
        }
        return count;
    }
}