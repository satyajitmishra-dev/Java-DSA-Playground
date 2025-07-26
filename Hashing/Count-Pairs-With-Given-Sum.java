/*

++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

Example:
Input: arr[] = [1, 5, 7, -1, 5], target = 6 
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++
HashMap or Dictionary provides a more efficient solution to the 2Sum problem. Instead of checking every pair of numbers, we keep each number in a map as we go through the array. For each number, we calculate its complement (i.e., target - current number) and check if it’s in the map. If it is, increment the count variable by the occurrences of complement in map.

🌐 Resource (ctrl + click) ::https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/article/MTM3NTE0

 */

class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        HashMap <Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int ele : arr){
            int complement = target - ele;
            
            if(map.containsKey(complement)) count += map.get(complement);
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        return count;
    }
}