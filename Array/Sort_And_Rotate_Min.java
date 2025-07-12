/* 
Sorted and Rotated Minimum
Difficulty: EasyAccuracy: 40.57%Submissions: 155K+Points: 2
A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

Example:
Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element in the array.

Approach :: 

We can optimize the minimum element searching by using Binary Search where we find the mid element and then decide whether to stop or to go to left half or right half:

If arr[mid] > arr[high], it means arr[low ... mid] is sorted and we need to search in the right half. So we change low = mid + 1.

If arr[mid] <= arr[high], it means arr[mid ... high] is sorted and we need to search in the left half. So we change high = mid. (Note: Current mid might be the minimum element).

How do we terminate the search? One way could be to check if the mid is smaller than both of its adjacent, then we return mid. This would require a lot of condition checks like if adjacent indexes are valid or not and then comparing mid with both. We use an interesting fact here: If arr[low] < arr[high], then the current subarray is sorted, So we return arr[low].

 */

// Geeks For Geeks Code

// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
       int low = 0, high = arr.length - 1;
       
       while(low < high){
           if(arr[low] < arr[high]) return arr[low];
           int mid = low + (high - low)/2;
           
          if(arr[mid] > arr[high]) low = mid + 1;
          else high = mid;
       }
       return arr[low];
    }
}
