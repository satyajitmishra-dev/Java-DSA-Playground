/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

Examples :
Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The input array is sorted, once we have found the index i such that arr[i] > (k + i), then for all indices j (j > i), arr[j] will also be greater than (k + j). So, we can optimize the previous approach using binary search to find the index i so that the k-th missing element is k + i.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/article/MTk0MjQx


 */

class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int low = 0, high = arr.length - 1;
        int ans = arr.length + k;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] > mid + k){
                ans = mid + k;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return ans;
    }
}