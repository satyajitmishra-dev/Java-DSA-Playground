/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.

Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.

Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

Brute-force Approach: 

Generate Subarrays: 
First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = array size).
Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current element of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
Calculate XOR of the subarray: Inside loop j, we will XOR the current element to the XOR of the previous subarray i.e. xorr = XOR(a[i….j-1]) ^ arr[j]. 
Check the XOR and modify the count: After calculating the XOR, we will check if the sum is equal to the given k. If it is, we will increase the value of the count.
Intuition: If we carefully observe, we can notice that to get the XOR of the current subarray we just need to XOR the current element(i.e. arr[j]) to the XOR of the previous subarray i.e. arr[i….j-1].

Assume previous subarray = arr[i……j-1]
current subarray = arr[i…..j]
XOR of arr[i….j] = (XOR of arr[i….j-1]) ^ arr[j]
This is how we can remove the third loop and while moving j pointer, we can calculate the XOR.

# Optimal Approach:

In this approach, we are going to use the concept of the prefix XOR to solve this problem. Here, the prefix XOR of a subarray ending at index i, simply means the XOR of all the elements of that subarray.

Observation: Assume, the prefix XOR of a subarray ending at index i is xr. In that subarray, we will search for another subarray ending at index i, whose XOR is equal to k. Here, we need to observe that if there exists another subarray ending at index i, with XOR k, then the prefix XOR of the rest of the subarray will be xr^k. The below image will clarify the concept:


Now, for a subarray ending at index i with the prefix XOR xr, if we remove the part with the prefix XOR xr^k, we will be left with the part whose XOR is equal to k. And that is what we want.

Now, there may exist multiple subarrays with the prefix XOR xr^k. So, the number of subarrays with XOR k that we can generate from the entire subarray ending at index i, is exactly equal to the number of subarrays with the prefix XOR xr^k, present in that subarray.

So, for a subarray ending at index i, instead of counting the subarrays with XOR k, we can count the subarrays with the prefix XOR xr^k present in it.

That is why, instead of searching the subarrays with XOR k, we will keep the occurrence of the prefix XOR of the subarrays using a map data structure. 

In the map, we will store every prefix XOR calculated, with its occurrence in a <key, value> pair. Now, at index i, we just need to check the map data structure to get the number of times that the subarrays with the prefix XOR xr^k occur. Then we will simply add that number to our count.

We will apply the above process for all possible indices of the given array. The possible values of the index i can be from 0 to n-1(where n = size of the array).

Approach:
The steps are as follows:

First, we will declare a map to store the prefix XORs and their counts.
Then, we will set the value of 0 as 1 on the map.
Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
For each index i, we will do the following:
We will XOR the current element i.e. arr[i] to the existing prefix XOR.
Then we will calculate the prefix XOR i.e. xr^k, for which we need the occurrence.
We will add the occurrence of the prefix XOR xr^k i.e. mpp[xr^k] to our answer.
Then we will store the current prefix XOR, xr in the map increasing its occurrence by 1.
Question: Why do we need to set the value of 0 beforehand?
Let’s understand this using an example. Assume the given array is [3, 3, 1, 1, 1] and k is 3. Now, for index 0, we get the total prefix XOR as 3, and k is also 3. So, the prefix XOR xr^k will be = 3^3 = 0. Now, if the value is not previously set for the key 0 in the map, we will get the default value 0 and we will add 0 to our answer. This will mean that we have not found any subarray with XOR 3 till now. But this should not be the case as index 0 itself is a subarray with XOR k i.e. 3.
So, in order to avoid this situation we need to set the value of 0 as 1 on the map beforehand.

🌐 Resource (ctrl + click) :: https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/
 */

// Brute-force Approach

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int count = 0;
        for(int i = 0; i < arr.length; i++){
        int xor = 0;
            for(int j = i; j < arr.length; j++){
                    xor = xor ^ arr[j];
                if(xor == k) count++;
                
            }
        }
        return count;
    }
}


// Optimal Approach (Using HashMap data structure)

   class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int count = 0;
        HashMap <Integer, Integer> map = new HashMap<>();
        
        int prefixXOR = 0;
        
        for(int ele : arr){
            prefixXOR ^= ele;
            
            count += map.getOrDefault(prefixXOR ^ k, 0);
            
            if(prefixXOR == k) count++;
            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
        }
        return count;
    }
}