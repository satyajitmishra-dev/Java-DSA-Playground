/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Sum Pair Closest to Target
You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.

Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.

Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 125.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to use the two-pointer technique by maintaining two pointers, say left and right and initialize them to the first and last element of the array respectively. According to the sum of left and right pointers, we can have three cases:

arr[left] + arr[right] < target: We need to increase the sum of pair, move the left pointer towards right.
arr[left] + arr[right] > target: We need to decrease the sum of pair, move the right pointer towards left.
arr[left] + arr[right] = target: We have found a pair whose sum is equal to target. We can find the product of the count of both the elements and add them to the result.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/two-pointer-technique-gfg-160/article/MzIxNjM0

*/

// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int left = 0, right = arr.length - 1;
        int count = 0;
        while(left < right){
            int sum = arr[left] + arr[right];
            
            //sum is Less
            
            if(sum < target) left++;
            // Sum is Greater than target
            else if(sum > target) right--;
            // if Sum Equal
            else{
                
                // Left & right Element are same
            if(arr[left] == arr[right]){
                int n = right - left + 1;
                count += (n*(n-1))/2;
                break;
            } 
            int leftVal = arr[left], rightVal = arr[right];
            int countLeft = 0, countRight = 0;
            
            while(left <= right && arr[left] == leftVal){
                left++;
                countLeft++;
            }
            while(right >= left && arr[right] == rightVal){
                right--;
                countRight++;
            }
            count += countLeft * countRight;
            }
        }
        return count;
    }
}
