/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Reverse a Doubly Linked List (GFG  , Easy)

You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input:
   
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 
   
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:
1 ≤ number of nodes ≤ 106
0 ≤ node->data ≤ 104



++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to reverse doubly linked list using two pointers for traversing through the list and swapping the next and previous pointers of every two consecutive nodes. 

Step-by-step algorithm:

Initially, prevNode is set to NULL and currNode starts at the head.
As the list is traversed,
=> Swap the currNode->next and currNode->prev
=> Move currNode to the next node, currNode = currNode->prev.
After traversing all the nodes, prevNode will point to the second node of the reversed list, so update the previous pointer of prevNode as the new head of the linked list, head = prevNode->prev and return it.

🌐 Resource (ctrl + click) ::https://www.geeksforgeeks.org/dsa/reverse-a-doubly-linked-list/

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

public class Solution {

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node currNode = head;
        Node prevNode = null;

        // Traverse the list and reverse the links
        while (currNode != null) {
          
            // Swap the next and prev pointers
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;

            // Move to the next node in the original list
            // (which is now previous due to reversal)
            currNode = currNode.prev;
        }

        head = prevNode.prev;

        return head;
    }
}