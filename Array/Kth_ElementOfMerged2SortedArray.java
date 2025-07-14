/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given two sorted arrays of sizes m and n respectively, the task is to find the element that would be at the k-th position in the final sorted array formed by merging these two arrays.

Examples: 
Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final sorted array is [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element is 6.

++++++++++++++++++++++++++++++++  APPROACH   ++++++++++++++++++++++++++++++++++++++++++++++++++

The approach is similar to the Binary Search approach of Median of two sorted arrays of different sizes.

Consider the first array is smaller. If first array is greater, then swap the arrays to make sure that the first array is smaller.

We mainly maintain two sets in this algorithm by doing binary search in the smaller array. Let mid1 be the partition of the smaller array. The first set contains elements from 0 to (mid1 – 1) from smaller array and mid2 = (k – mid1) elements from the greater array to make sure that the first set has exactly k elements. The second set contains remaining elements.

Our target is to find a point in both arrays such that all elements in the first set are smaller than all elements in the other set (set that contains elements from right side). For this we validate the partitions using the same way as we did in Median of two sorted arrays of different sizes.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/article/MTQ3MTYx

 */



class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n = a.length, m = b.length;
        
        if(n < m) return kthElement(b, a, k);
        
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);
        
        while(low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;
            
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);
            
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2  = (mid2 == m ? Integer.MAX_VALUE : b[mid2]);
            
            if(l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
            
            if(l1 > l2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }
}