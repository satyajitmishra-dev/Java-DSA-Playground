/* 
Given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist). If there are multiple peak elements, return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".

Note: Consider the element before the first element and the element after the last element to be negative infinity.

++++++++++++++++++++++++++++++++  EXAMPLES   ++++++++++++++++++++++++++++++++++++++++++++++++++

Examples :
Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].

++++++++++++++++++++++++++++++++  APPROACH   ++++++++++++++++++++++++++++++++++++++++++++++++++

If we observe carefully, we can say that:

If an element is smaller than it's next element then it is guaranteed that at least one peak element will exist on the right side of this element.
Conversely if an element is smaller than it's previous element then it is guaranteed that at least one peak element will exist on the left side of this element.
Therefore, we can use binary search to find the peak element.

Why it is guaranteed that peak element will definitely exist on the right side of an element, if its next element is greater than it?

If we keep moving in the right side of this element, as long as the elements are increasing, we will eventually reach an element that is either:

The last element of the array, which will be a peak as it is greater than or equal to its previous element.
An element where the sequence is no longer increasing, i.e., arr[i] > arr[i + 1], which would be a peak element.
For the same reasons, if an element is lesser than its previous element, then it is guaranteed that at least one peak element will exist on the left side of that element.


🌐 Resource :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/article/MTE4MDE2
 */

class Solution {

    public int peakElement(int[] arr) {
        // code here
        int n = arr.length;
        
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n - 1] > arr[n - 2]) return n - 1;
       
        
        int low = 1, high = n - 2;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if(arr[mid] < arr[mid + 1]) low = mid + 1;
            else high = mid - 1;
        }
        return 0;
    }
}