/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Find length of Loop (GFG  , Medium)


// # This is very important question For your interview

Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.

Note: Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null, indicating there is no loop. Note that pos is not passed as a parameter.

Examples:

Input: pos = 2,
   
Output: 4
Explanation: There exists a loop in the linked list and the length of the loop is 4.
Input: pos = 3,
   
Output: 3
Explanation: The loop is from 19 to 10. So length of loop is 19 → 33 → 10 = 3.
Input: pos = 0,
    
Output: 0
Explanation: There is no loop.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 104
0 ≤ pos < number of nodes

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

 Using Floyd’s Cycle Detection Algorithm - O(n) Time and O(1) Space

The idea is to use Floyd’s Cycle detection algorithm for detecting the common point in the loop. Using fast and slow pointer

Step by Step Approach:

Use a fast and slow pointer pointing to head of linked list.
move fast pointer to fast->next->next and slow pointer to slow->next.
If a common meeting point exists between the slow and fast pointers, it confirms the presence of a loop.
Once the loop is detected, we start counting the number of nodes in the loop by initializing a counter and traversing the loop starting from the meeting point.
If no meeting point is found, it means there is no loop, so we return 0.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/find-length-of-loop-in-linked-list/
*/

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
        // code here
        static int countNodes(Node node) {
        int res = 1;
        Node curr = node;
        while (curr.next != node) {
            res++;
            curr = curr.next;
        }
        return res;
    }

    // Detects and Counts nodes in loop
    static int lengthOfLoop(Node head) {
        Node slow = head, fast = head;

        while (slow != null && fast != null 
               && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // if slow and fast meet at
            // some point then there is a loop
            if (slow == fast)
                return countNodes(slow);
        }

        return 0;
    }
}