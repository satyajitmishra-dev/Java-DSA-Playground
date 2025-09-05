/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Sort a linked list of 0s, 1s and 2s (GFG  , Medium)


// # This is very important question For your interview

Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
   
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
   
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

Keeping count of values

Intuition: Since in this case there are only 3 distinct values in the array so it's easy to maintain the count of all, Like the count of 0, 1, and 2. This can be followed by overwriting the array based on the frequency(count) of the values.

Approach: 

Take 3 variables to maintain the count of 0, 1 and 2.
Travel the array once and increment the corresponding counting variables
( let's consider count_0 = a, count_1 = b, count_2 = c )

In 2nd traversal of array, we will now over write the first ‘a’ indices / positions in array with ’0’, the next ‘b’ with ‘1’ and the remaining ‘c’ with ‘2’.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/sort-a-linked-list-of-0s-1s-or-2s/

*/

// class Node {
//     int data;
//     Node next;
//     Node prev;

//     Node(int data) {
//         this.data = data;
//         this.next = null;
//         this.prev = null;
//     }
// }

class Solution {
    public Node segregate(Node head) {
        // code here
         int[] cnt = { 0, 0, 0 };
        Node ptr = head;

        // Traverse and count total number of '0', '1' and '2'
        // cnt[0] will store total number of '0's
        // cnt[1] will store total number of '1's
        // cnt[2] will store total number of '2's
        while (ptr != null) {
            cnt[ptr.data] += 1;
            ptr = ptr.next;
        }

        int idx = 0;
        ptr = head;
  
        while (ptr != null) {
            if (cnt[idx] == 0)
                idx += 1;
            else {
                ptr.data = idx;
                cnt[idx] -= 1;
                ptr = ptr.next;
            }
        }
        return head;
    }
}