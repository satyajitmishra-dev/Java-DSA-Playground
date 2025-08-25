/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement:  Add Number Linked Lists
// Difficulty Level : Medium(GFG)

Given head of two singly linked lists head1 and head2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: head1 = 4 -> 5, head2 = 3 -> 4 -> 5
Output:  3 9 0
Explanation: Given numbers are 45 and 345. There sum is 390.


Input: head1 = 0 -> 0 -> 6 -> 3, head2 = 0 -> 7 
Output: 7 0 
Explanation: Given numbers are 63 and 7. There sum is 70.

Constraints:
1 ≤ list1.size, list2.size ≤ 5*105
0 ≤ node->data ≤ 9




++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

o sum two linked lists, start by creating an empty linked list, say result, for the sum. Reverse both original linked lists to start from the least significant digit.

Use two pointers to traverse the reversed lists simultaneously. For each pair of nodes, compute their sum and if the sum exceeds 9, store the remainder(sum modulo 10) in the new node and forward the carry to the next pair of nodes. Append each new node to result.

Continue until both lists are fully traversed, handling any remaining nodes from the longer list and carrying over any final carry. Finally, reverse the result linked list to get the sum of the two linked list.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/add-two-numbers-represented-by-linked-list/
🌐 Resource (ctrl + click) :: https://takeuforward.org/data-structure/reverse-a-linked-list/




*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    
    static Node reverseList(Node head){
        Node prev = null;
        Node current = head;
        Node next = head;
        
        while(current != null){
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
        }
        return prev;
    }
    static Node trimLeadingZeros(Node head){
        
        while(head != null && head.data == 0){
            head = head.next;
        }
        return head;
    }
    
    static Node addTwoLists(Node head1, Node head2) {
        
        Node res = null;
        Node curr = null;
        int carry = 0;
       
       head1 = trimLeadingZeros(head1);
       head2 = trimLeadingZeros(head2);
       
       head1 = reverseList(head1);
       head2 = reverseList(head2);
       
       while(head1 != null || head2 != null || carry != 0){
           int sum = carry;
           
           if(head1 != null){
               sum += head1.data;
               head1 = head1.next;
           }
           if(head2 != null){
               sum += head2.data;
               head2 = head2.next;
           }
           
           Node ansNode = new Node(sum % 10);
           carry = sum/10;
           
           if(res == null){
               res = ansNode;
               curr = ansNode;
           }
           else{
               curr.next = ansNode;
               curr = curr.next;
           }
       }
       return reverseList(res);
    }
}

