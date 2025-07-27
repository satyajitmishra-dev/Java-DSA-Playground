/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
Returned triplet should also be internally sorted i.e. i<j<k.

Example:
Input: arr[] = [0, -1, 2, -3, 1]
Output: [[0, 1, 4], [2, 3, 4]]
Explanation: Triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0

++++++++++++++++++++++++++++++++  APPROACH  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to use a hash map to store indices of each element and efficiently find triplets that sum to zero.
We iterate through all pairs (j, k), compute the required third element as -(arr[j] + arr[k]), and check if it exists in the map with a valid index i < j.
If found, we store {i, j, k} in the result. To ensure unique triplets, the map maintains only indices less than the current j.
In the worst case, this approach also takes O(n^3) time but in the average case, it is much faster than Naive approach as we are iterating over only those triplets whose sum is equal to target.


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/article/MTQxMDk1

 */

// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int j = 0; j < arr.length; j++){
            for(int k = j + 1; k < arr.length; k++){
                
                int third = -1 * (arr[j] + arr[k]);
                
                if(map.containsKey(third)){
                    for(int i : map.get(third)){
                        ans.add(Arrays.asList(i, j, k));
                    }
                }
            }
            map.putIfAbsent(arr[j], new ArrayList<>());
            map.get(arr[j]).add(j);
        }
        return ans;
    }
}