/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given two integer arrays a[] and b[], you have to find the intersection of the two arrays. Intersection of two arrays is said to be elements that are common in both the arrays. The intersection should not have duplicate elements and the result should contain items in any order.

Note: The driver code will sort the resulting array in increasing order before printing.

Example:
Input: a[] = [1, 2, 1, 3, 1], b[] = [3, 1, 3, 4, 1]
Output: [1, 3]
Explanation: 1 and 3 are the only common elements and we need to print only one occurrence of common elements.

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

Initialize an empty set to store unique elements from the first array a[].

Traverse the first array a[]:

Add each element to the set.

This removes duplicates and allows fast lookup.

Initialize another empty set to store the intersection (common elements).

Traverse the second array b[]:

For each element in b[], check if it exists in the set from step 1.

If yes, add it to the result set (this ensures no duplicates in the result).

Convert the result set to a list or array (if needed, depending on the return type).


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/article/MTMyODc1NQ%3D%3D

 */

class Solution {
    public ArrayList<Integer> intersect(int[] a, int[] b) {
        // code here
        Set <Integer> setA = new HashSet<>();
        Set <Integer> setB = new HashSet<>();
        for(int ele : a){
            setA.add(ele);
        }
        
        for(int ele : b){
            // Set Maintain Uniqueness
            if(setA.contains(ele)){
                setB.add(ele);
            }
        }
        return new ArrayList<>(setB);
    }
}