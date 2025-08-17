/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Product array puzzle

Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.

Examples:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.

Input: arr[] = [12, 0]
Output: [0, 12]
Explanation: For i = 0, res[i] is 0.
For i = 1, res[i] is 12.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
// Approach: Product Array (Just think new result arrays[i] = totalProduct / arr[i])

The idea is to handle two special cases of the input array: when it contains zero(s) and when it doesn't.

If the array has no zeros, product of array at any index (excluding itself) can be calculated by dividing the total product of all elements by the current element. 

However, division by zero is undefined, so if there are zeros in the array, the logic changes. If there is exactly one zero, the product for that index will be the product of all other non-zero elements, while the elements in rest of the indices will be zero. 
If there are more than one zero, the product for all indices will be zero, since multiplying by zero results in zero.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/a-product-array-puzzle/

*/

// Product Array 

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int product = 1, indx = -1, noOfZeros = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                noOfZeros++;
                indx = i;
            }
            else {
                product *= arr[i];
            }
        }
        
        int[] ans = new int[arr.length];
        Arrays.fill(ans, 0); // For initialize all elements to zero
        
        if(noOfZeros == 0){
            for(int i = 0; i < arr.length; i++){
                ans[i] = product/arr[i]; // Calculate product except self
            }
        }
        else if(noOfZeros == 1){
                ans[indx] = product;
            }
        return ans;
    }
}

