/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
Given an array arr[] of integers and another integer target. Determine if there exist two distinct indices such that the sum of their elements is equal to the target.

Example:
Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: true
Explanation: arr[3] + arr[4] = -3 + 1 = -2

++++++++++++++++++++++++++++++++++++++++++  APPROACH   +++++++++++++++++++++++++++++++++++++++++++++++++
# Step-by-Step Approach:

1. Create a HashSet to store the elements of the array.
2. Iterate through each element in the array.
3. For each element, calculate the complement (target - current element).
4. Check if the complement exists in the HashSet.
5. If it exists, return true.
6. If not, add the current element to the HashSet.
# At the end of the loop, if no such pair is found, return false.


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/article/NDg0
🌐 Resource (ctrl + click) :: https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/
 */
import java.util.HashSet;

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        HashSet<Integer> set = new HashSet<>();

        for(int ele: arr){
            int complement = target - ele;
            if(set.contains(complement)) return true;
             set.add(ele);
        }
        return false;
    }
}

