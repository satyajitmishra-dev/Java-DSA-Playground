/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Next Greater Element in Circular Array (GFG  , Medium)

Given a circular integer array arr[], the task is to determine the next greater element (NGE) for each element in the array.

The next greater element of an element arr[i] is the first element that is greater than arr[i] when traversing circularly. If no such element exists, return -1 for that position.

Note: Since the array is circular, after reaching the last element, the search continues from the beginning until we have looked at all elements once.

Examples: 

Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
Explanation:
The next greater element for 1 is 3.
The next greater element for 3 is 4.
The next greater element for 2 is 4.
The next greater element for 4 does not exist, so return -1.

Input: arr[] = [0, 2, 3, 1, 1]
Output: [2, 3, -1, 2, 2]
Explanation:
The next greater element for 0 is 2.
The next greater element for 2 is 3.
The next greater element for 3 does not exist, so return -1.
The next greater element for 1 is 2 (from circular traversal).
The next greater element for 1 is 2 (from circular traversal).

Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 106

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
We use the same ideas as next greater element in a normal array. Stack to find out the next greater element in linear time. We traverse the array from right to left. For each element, we remove elements from the stack that are smaller than or equal to it, as they cannot be the next greater element. If the stack is not empty after this, the top element of the stack is the next greater element for the current element. We then push the current element onto the stack.

Step By Step Implementations:

Initialize res with -1 and an empty stack st.
Loop from 2n - 1 to 0 to handle circular traversal.
Use i%n to access the correct index in the array.
While stack is not empty and top element is ≤ current element, pop from stack.
If i < n and stack is not empty, set res[i] to st.top().
Push current element arr[i % n] to the stack.
Return the result array res.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/find-the-next-greater-element-in-a-circular-array/#expected-approach-using-stack-on-time-and-on-space
*/

import java.util.ArrayList;
import java.util.Stack;

class Solution {

    static ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;

        // Step 1: Initialize result array with -1
        // (default is -1 when no greater element exists)
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        // Step 2: Use a stack to keep "candidates" for next greater element
        // We'll store numbers (not indexes) in this stack
        Stack<Integer> st = new Stack<>();

        // Step 3: Traverse the array twice (2*n - 1 down to 0)
        // Why twice? -> Because it's a circular array.
        // i % n makes sure we wrap around.
        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = arr[i % n];  // Current element (with wrap-around)

            // Step 4: Pop all elements from stack that are smaller or equal
            // to the current number, since they can't be "next greater".
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            // Step 5: If we are in the first pass (i < n)
            // and stack is not empty → top of stack is the next greater element
            if (i < n && !st.isEmpty()) {
                res[i] = st.peek();
            }

            // Step 6: Push current element into stack for future comparisons
            st.push(curr);
        }

        // Step 7: Convert result array into ArrayList (as required by function)
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : res) {
            result.add(val);
        }

        return result;
    }
}
