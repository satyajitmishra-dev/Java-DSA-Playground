/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Sum Pair Closest to Target

Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

Examples:

Input: arr[] = [4, 6, 3, 7]
Output: 3
Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle.  

Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
Output: 6
Explanation: There can be 6 possible triangles: [10, 21, 22], [21, 100, 101], [22, 100, 101], [10, 100, 101], [100, 101, 200] and [101, 200, 300]

Input: arr[] = [1, 2, 3]
Output: 0
Explanation: No triangles are possible.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to sort the array to simplify checking the triangle inequality. Then, for each element (treated as the largest side), use two pointers technique to find count of pairs of smaller sides that can form a triangle with it. 
For this, the two pointers are initialized as: one pointer (left) starts at index 0, and the other pointer (right) is positioned just before the current largest side (arr[i]).

Now, compare the sum of arr[left] + arr[right] with the current largest side (arr[i]):

If the sum is greater than or equal to arr[i], a valid triangle can be formed. Count all valid pairs between left and right, then move the right pointer to the left to explore smaller side values.
If the sum is less than arr[i], increment the left pointer to increase the sum and check larger values.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/find-number-of-triangles-possible/

*/

class Solution {
    public int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int count = 0;
        
        for(int i = 2; i < arr.length; i++){
            int left = 0, right = i - 1;
            
            while(left < right){
                
                if(arr[left] + arr[right] > arr[i]){
                    count += right - left;
                    right--;
                } 
                else left++;
            }
        }
        return count;
    }
}