/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
You are given two arrays a[] and b[], return the Union of both the arrays in any order.

The Union of two arrays is a collection of all distinct elements present in either of the arrays. If an element appears more than once in one or both arrays, it should be included only once in the result.

Note: Elements of a[] and b[] are not necessarily distinct.
Note that, You can return the Union in any order but the driver code will print the result in sorted order only.

Examples:

Input: a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
Output: [1, 2, 3]
Explanation: Union set of both the arrays will be 1, 2 and 3.

Input: a[] = [1, 2, 3], b[] = [4, 5, 6] 
Output: [1, 2, 3, 4, 5, 6]
Explanation: Union set of both the arrays will be 1, 2, 3, 4, 5 and 6.

++++++++++++++++++++++++++++++++ APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

Create an empty HashSet to store unique elements.
Traverse the first array, and add each element to the HashSet.
Traverse the second array, and add each element to the same HashSet.
The HashSet now contains all unique elements from both arrays.
Convert the HashSet to a list or array (if needed) and return it.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/union-of-two-sorted-arrays/#better-approach-using-set-on-m-log-n-m-time-and-on-m-space

 */
    class Solution {
        public static ArrayList<Integer> findUnion(int[] a, int[] b) {
            // Create a HashSet to store only unique elements (no duplicates allowed)
            HashSet<Integer> setA = new HashSet<>();
            
            // Add all elements from the first array to the set
            for(int ele : a){
                setA.add(ele); // HashSet automatically handles duplicates
            }

            // Add all elements from the second array to the set
            for(int ele : b){
                setA.add(ele); // Again, duplicates will not be added
            }

            // Convert the set to an ArrayList and return it
            return new ArrayList<>(setA);
        }
    }
