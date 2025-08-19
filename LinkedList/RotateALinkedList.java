/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Rotate a Linked List

Given the head of a singly linked list, your task is to left rotate the linked list k times.

Examples:

Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Input: head = 10 -> 20 -> 30 -> 40 , k = 6
Output: 30 -> 40 -> 10 -> 20 
 
Constraints:

1 <= number of nodes <= 105
0 <= k <= 109
0 <= data of node <= 109


++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to first convert the linked list to circular linked list by updating the next pointer of last node to the head of linked list. Then, traverse to the kth node and update the head of the linked list to the (k+1)th node. Finally, break the loop by updating the next pointer of kth node to NULL.. 

How to handle large values of k?

For a linked list of size n, if we rotate the linked list to the left by n places, then the linked list will remain unchanged and if we rotate the list to the left by (n + 1) places, then it is same as rotating the linked list to the left by 1 place. Similarly, if we rotate the linked list k (k >= n) places to the left, then it is same as rotating the linked list by (k % n) places. So, we can simply update k with k % n to handle large values of k.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/rotate-a-linked-list/

*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

class Solution {
    public Node rotate(Node head, int k) {
        // Handle Base Case --> Step 1
        if(head == null || head.next == null) return head;
        
        // Find Length --> Step 2
        Node temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        
        // If K is greater than length 
        k = k % length;
        if(k == 0) return head;
        
        Node current = head;
        
        // Move fast to K steps
        for(int i = 1; i < k ; i++){
            current = current.next;
        }
        
        Node newHead = current.next;
        current.next = null;
        Node last = newHead;
        
        while(last.next != null){
            last = last.next;
        }
        // Create new Head for Connection
       
        last.next = head;
        
        return newHead;
    }
}