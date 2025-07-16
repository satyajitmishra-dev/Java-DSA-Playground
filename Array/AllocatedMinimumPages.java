/* 
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Example:
Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
[12] and [34, 67, 90] Maximum Pages = 191
[12, 34] and [67, 90] Maximum Pages = 157
[12, 34, 67] and [90] Maximum Pages = 113.
Therefore, the minimum of these cases is 113, which is selected as the output.

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

The maximum number of pages(page limit) that a student can be allocated has a monotonic property:

If, at a page limit p, books cannot be allocated to all k students, then we need to reduce the page limit to ensure more students receive books.
If, at a page limit p, we can allocate books to more than k students, then we need to increase the page limit so that fewer students are allocated books.
Therefore, we can apply binary search to minimize the maximum pages a student can be allocated. To check the number of students that can be allotted books for any page limit, we start assigning books to the first student until the page limit is reached, then move to the next student.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/article/MTQxMTA2

 */


class Solution {
    public static boolean check(int[] arr, int k, int pagesLimit) {
        int cnt = 1, pageSum = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(pageSum + arr[i] > pagesLimit){
                cnt++;
                pageSum = arr[i];
            } else {
                pageSum +=arr[i];
            }
        }
        return (cnt <= k);
    }
    
    public static int findPages(int[] arr, int k) {
        // code here
        if(k > arr.length) return -1;
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(check(arr, k, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}