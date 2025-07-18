/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.

Example :
Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is found at index 8.

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

Using Single Binary Search - O(log n) Time and O(1) Space

The idea is based on the fact that in a sorted and rotated array, if we go to mid, then either the left half would be sorted or the right half (both can also be sorted). For example, arr[] = [5, 6, 0, 1, 2, 3, 4], mid = 3 and we can see that the subarray from mid + 1 to high is sorted. And in [5, 6, 7, 8, 9, 3, 4], we can see that the subarray from low to mid-1 is sorted. We can check which half is sorted by comparing arr[low] and arr[mid] (We could also compare arr[high] and arr[mid]).

Find the mid point. If key is same as the mid, return the mid.
Find which half is sorted. If the key lies in the sorted half, move to that half. Otherwise move to the other half.

# Note that once we find which half is sorted, we can easily check if the key lies here by checking if key lies in the range from smallest to largest in this half.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/article/MTA2OA%3D%3D

 */

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int low = 0, high = arr.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
           if(arr[mid] == key) return mid;
           if(arr[mid] >= arr[low]){
               if(arr[low] <= key && key < arr[mid]){
                   high = mid - 1;
               } else low = mid + 1;
           }
           else {
               if(key > arr[mid] && key <= arr[high]){
                   low = mid + 1;
               }
               else high = mid - 1;
           }
           
        }
        return -1;
    }
}