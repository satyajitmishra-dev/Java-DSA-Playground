/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Longest Subarray with Sum K


Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.

Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
// Approach: Brute Force

The steps are as follows:

First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = array size).
Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current element of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
Inside loop j, we will add the current element to the sum of the previous subarray i.e. sum = sum + arr[j]. 
If the sum is equal to k, we will consider its length i.e. (j-i+1). Among all such subarrays with sum k, we will consider the one with the maximum length by comparing all the lengths.
Intuition: If we carefully observe, we can notice that to get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].

Assume previous subarray = arr[i……j-1]
current subarray = arr[i…..j]
Sum of arr[i….j] = (sum of arr[i….j-1]) + arr[j]

This is how we can remove the third loop and while moving the j pointer, we can calculate the sum.

// Approach: Prefix Sum & HashMap

The steps are as follows:

First, we will declare a map to store the prefix sums and the indices.
Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
For each index i, we will do the following:
We will add the current element i.e. a[i] to the prefix sum.
If the sum is equal to k, we should consider the length of the current subarray i.e. i+1. We will compare this length with the existing length and consider the maximum one.
We will calculate the prefix sum i.e. x-k, of the remaining subarray.
If that sum of the remaining part i.e. x-k exists in the map, we will calculate the length i.e. i-preSumMap[x-k], and consider the maximum one comparing it with the existing length we have achieved until now.
If the sum, we got after step 3.1, does not exist in the map we will add that with the current index into the map. We are checking the map before insertion because we want the index to be as minimum as possible and so we will consider the earliest index where the sum x-k has occurred. [Detailed discussion in the edge case section]
In this approach, we are using the concept of the prefix sum to solve this problem. Here, the prefix sum of a subarray ending at index i, simply means the sum of all the elements of that subarray.

Observation: Assume, the prefix sum of a subarray ending at index i is x. In that subarray, we will search for another subarray ending at index i, whose sum equals k. Here, we need to observe that if there exists another subarray ending at index i with sum k, then the prefix sum of the rest of the subarray will be x-k. The below image will clarify the concept:

Now, for a subarray ending at index i with the prefix sum x, if we remove the part with the prefix sum x-k, we will be left with the part whose sum is equal to k. And that is what we want.

That is why, instead of searching the subarrays with sum k, we will keep track of the prefix sum of the subarrays generated at every index using a map data structure. 

In the map, we will store every prefix sum calculated, with the index(where the subarray with that prefix sum ends) in a <key, value> pair. Now, at index i, we just need to check the map data structure to get the index i.e. preSumMap[x-k] where the subarray with the prefix sum x-k ends. Then we will simply subtract that index i.e. preSumMap[x-k] from the current index i to get the length of the subarray with sum k i.e. len = i -preSumMap[x-k].

We will apply the above process for all possible indices of the given array. The possible values of the index i can be from 0 to n-1(where n = size of the array).

Edge Case: Why do we need to check the map if the prefix sum already exists?

In the algorithm, we have seen that at step 3.4, we are checking the map if the prefix sum already exists, and if it does we are not updating it. Let’s understand the reason by considering the following example:
Assume the given array is {2, 0, 0, 3}. If we apply the algorithm to the given array without checking, it will be like the following:


In steps 2 and 3 the element at index i is 0. So, in those steps, the prefix sum remains the same but the index is getting updated in the map. Now, when index i reaches the end, it calculates the length i.e. i-preSumMap[rem] = 3-2 = 1. Here it is considering only the subarray [3] which is incorrect as the longest subarray we can get is [0, 0, 3] and hence the length should be 3.

Now, to avoid this edge case i.e. to maximize the calculated length, we need to observe the formula we are using to calculate the length i.e. len = i - preSumMap[rem].

Now, if we minimize the term preSumMap[rem] (i.e. the index where the subarray with sum x-k ends), we will get the maximum length. That is why we will consider only the first or the leftmost index where the subarray with sum x-k ends. After that, we will not update that particular index even if we get a similar subarray ending at a later index.

So, we will check the map before inserting the prefix sum. If it already exists in the map, we will not update it but if it is not present, we will insert it for the first time.


🌐 Resource (ctrl + click) :: https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/longest-sub-array-sum-k/
*/

// Brute Force Approach
// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {

        int n = arr.length,maxLength = 0;
        
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += arr[j];
                if(sum == k){
                    maxLength = Math.max(maxLength, j - i + 1); // +1 add for get exact length of subarray
                }
            }
        }
        return maxLength;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)

// Prefix Sum & HashMap Approach

// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        Map <Integer, Integer> map = new HashMap<>();
        int prefixSum = 0,maxLength = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            prefixSum += arr[i];
            if(prefixSum == k) maxLength = i + 1;
            
            else if(map.containsKey(prefixSum - k)){
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n) - for storing prefix sums in the map
