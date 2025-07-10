/* 
Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it contains the last m elements.

Examples:
Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output:

2 2 3 4
7 10

Explanation: After merging the two non-decreasing arrays, we get, [2 2 3 4 7 10]

Approach :: Actually we can use the previous approach without finding the pivot index. We just need to swap the rightmost element in a[] with leftmost element in b[], then second rightmost element in a[] with second leftmost element in b[] and so on. This will continue until the selected element from a[] is larger than selected element from b[].

*/

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        int i = a.length - 1;
        int j = 0;
        
        while(i >= 0 && j < b.length){
            if(a[i] < b[j]) i--;
            
            else{
                int temp = a[i];
                a[i] = b [j];
                b[j] = temp;
                i--;
                j++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
