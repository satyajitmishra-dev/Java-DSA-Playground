/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.

Note: In the case of a single vertical line it will not be able to hold water.

Examples:

Input: arr[] = [1, 5, 4, 3]
Output: 6
Explanation: 5 and 3 are 2 distance apart. So the size of the base is 2. Height of container = min(5, 3) = 3. So, total area to hold water = 3 * 2 = 6.

Input: arr[] = [3, 1, 2, 4, 5]
Output: 12
Explanation: 5 and 3 are 4 distance apart. So the size of the base is 4. Height of container = min(5, 3) = 3. So, total area to hold water = 4 * 3 = 12.

Input: arr[] = [2, 1, 8, 6, 4, 6, 5, 5]
Output: 25 
Explanation: 8 and 5 are 5 distance apart. So the size of the base is 5. Height of container = min(8, 5) = 5. So, the total area to hold water = 5 * 5 = 25.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
The idea is to maintain two pointers: left pointer at the beginning of the array and right pointer at the end of the array. These pointers act as the container's sides so we can calculate the amount of water stored between them using the formula: min(arr[left], arr[right]) * (right - left). 

After calculating the amount of water for the given sides, we can have three cases:

arr[left] < arr[right]: This means that we have calculated the water stored for the container of height arr[left], so increment left by 1.
arr[left] >= arr[right]: This means that we have calculated the water stored for the container of height arr[right], so decrement right by 1.
Repeat the above process till left is less than right keeping track of the maximum water stored as the result.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/container-with-most-water/


*/

class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        int left = 0, right = arr.length - 1;
        int ans = 0;
        
        while(left < right){
            
            int water = Math.min(arr[left], arr[right]) * (right - left);
            ans = Math.max(ans, water);
            
            if(arr[left] < arr[right]) left++;
            else right--;
        }
        return ans;
    }
}