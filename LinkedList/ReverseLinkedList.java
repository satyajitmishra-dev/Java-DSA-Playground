/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Reverse Linked List

Given the head of a linked list, the task is to reverse this list and return the reversed head.

Examples:

Input: head: 1 -> 2 -> 3 -> 4 -> NULL
Output: 4 3 2 1
Explanation:

Input: head: 2 -> 7 -> 10 -> 9 -> 8 -> NULL
Output: 8 9 10 7 2
Explanation:

Input: head: 2 -> NULL
Output: 2
Explanation:


++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to reverse the links of all nodes using three pointers:

prev: pointer to keep track of the previous node
curr: pointer to keep track of the current node
next: pointer to keep track of the next node
Starting from the first node, initialize curr with the head of linked list and next with the next node of curr. Update the next pointer of curr with prev. Finally, move the three pointer by updating prev with curr and curr with next.

Follow the steps below to solve the problem:

Initialize three pointers prev as NULL, curr as head, and next as NULL.
Iterate through the linked list. In a loop, do the following:
Store the next node, next = curr -> next
Update the next pointer of curr to prev, curr -> next = prev
Update prev as curr and curr as next, prev = curr and curr = next

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/reverse-a-linked-list/

*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

class Solution {
    Node reverseList(Node head) {
        // code here
        if(head == null || head.next == null) return head;
        Node current = head, prev = null, nextToCurrnet = head;
        
        while(current != null){
            nextToCurrnet = current.next;
            current.next = prev;
            prev = current;
            current = nextToCurrnet;
        }
        return prev;
    }
}
