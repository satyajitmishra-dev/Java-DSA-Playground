/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Equilibrium Point

Given an array of integers arr[], the task is to find the first equilibrium point in the array.

The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists. 

Examples:

Input: arr[] = [1, 2, 0, 3]
Output: 2 
Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 3.

Input: arr[] = [1, 1, 1, 1]
Output: -1
Explanation: There is no equilibrium index in the array.

Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
Output: 3
Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
// Approach: Brute Force

The most basic idea is to use nested loops.

The outer loop iterates through all the indices one by one. Consider it as equilibrium index.
The inner loop finds out whether index i is equilibrium index or not, by checking if left side sum = right side sum.

// Approach: Prefix Sum

The prefix sum approach can be used to optimize the brute force solution.
Now the above prefix sum array and suffix sum array approach can be further optimized in terms of space, by using prefix sum and suffix sum variables. The idea is that instead of storing the prefix sum and suffix sum for each element in an array, we can simply use the fact that 

PrefixSum(arr[0 : pivot - 1]) + arr[pivot] + SuffixSum[pivot + 1: n - 1] = ArraySum 

so, SuffixSum[pivot + 1: n - 1] = ArraySum - PrefixSum(arr[0 : pivot - 1]) 


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/equilibrium-index-of-an-array/
*/

// Brute Force Approach
class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        for(int i = 0; i < arr.length; i++){
            int leftSum = 0;
            for(int j = 0; j < i; j++){
                leftSum += arr[j];
            }
            int rightSum = 0;
             for(int k = i + 1; k < arr.length; k++){
                rightSum += arr[k];
            }
            if(rightSum == leftSum) return i;
        }
        return -1;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)
// Note: This is a brute force approach and can be optimized further using prefix sums or other techniques.
// The above code iterates through each element and calculates the left and right sums for each index

// Prefix Sum Approach

class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int totalSum = 0, prefixSum = 0;
        
        for(int ele: arr){
            totalSum += ele;
        }
        
        for(int i = 0; i < arr.length; i++){ // here i mean pivot point
            
            int suffixSum = totalSum - prefixSum - arr[i];
            if(prefixSum == suffixSum) return i;
            prefixSum += arr[i];
        }
        return -1;
    }
}
// time Complexity: O(n)
// Space Complexity: O(1)
// Note: This approach uses a single loop to calculate the prefix sum and checks the condition for equilibrium point.