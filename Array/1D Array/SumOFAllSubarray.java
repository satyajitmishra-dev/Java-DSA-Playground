/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
Given an array arr[], find the sum of all the subarrays of the given array.

Note: It is guaranteed that the total sum will fit within a 32-bit integer range.

Example:

Input: arr[] = [1, 2, 3] 
Output: 20
Explanation: All subarray sums are: [1] = 1, [2] = 2, [3] = 3, [1, 2] = 3, [2, 3] = 5, [1, 2, 3] = 6. Thus total sum is 1 + 2 + 3 + 3 + 5 + 6 = 20.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
Let's take an example: arr[] = [1, 4, 5, 3, 2]
All subarrays :  [1], [1, 4], [1, 4, 5], [1, 4, 5, 3], [1, 4, 5, 3, 2], [4], [4, 5], [4, 5, 3], [4, 5, 3, 2], [5], [5, 3], [5, 3, 2], [3], [3, 2], [2]

subbaray-sum
Third element arr[2] appears 3 time when subarray start with arr[0]: [1, 4, 5], [1, 4, 5, 3], [1, 4, 5, 3, 2]
Third element arr[2] appears 3 time when subarray start with arr[1]: [4, 5], [4, 5, 3], [4, 5, 3, 2]
Third element arr[2] appears 3 time when subarray start with arr[2]: [5], [5, 3], [5, 3, 2]

So, We can clearly see that, For any element arr[i] in an array of size n, it appears in exactly (i + 1) * (n - i) subarrays.

For arr[] = [1, 2, 3], sum of subarrays is: arr[0] * ( 0 + 1 ) * ( 3 - 0 )  +  arr[1] * ( 1 + 1 ) * ( 3 - 1 )  +  arr[2] * ( 2 + 1 ) * ( 3 - 2 ) = 1*3*3 + 2*2*2 + 3*3*1  = 20

Step by step Implementation:

Declare an integer answer equal to zero
Run a for loop for i from [0, n-1]: Add arr[i] * (i+1) * (n-i) into the answer at each iteration
Return answer


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/sum-of-all-subarrays/

// Time Complexity: O(n)
// Space Complexity: O(1)

 */

public class SumOFAllSubarray {
    public static int sumOfAllSubarrays(int[] arr) {
        int n = arr.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer += arr[i] * (i + 1) * (n - i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Sum of all subarrays: " + sumOfAllSubarrays(arr)); // Output: 20
    }
}