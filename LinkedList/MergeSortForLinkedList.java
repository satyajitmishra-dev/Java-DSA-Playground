/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Merge Sort for Linked List (GFG  , Medium)

You are given the head of a linked list. You have to sort the given linked list using Merge Sort.

Examples:

Input:
    
Output: 10 -> 20 -> 30 -> 40 -> 50 -> 60
Explanation: After sorting the given linked list, the resultant list will be:
    
Input:
    
Output: 2 -> 5 -> 8 -> 9
Explanation: After sorting the given linked list, the resultant list will be:
    
Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 106

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The prerequisite for this problem is Merge Sort. Here we have to maintain a MergeSort function that sorts the list in three steps:

Split the List into Two Halves: Use two pointers, fast and slow, starting at the head. Move fast two steps and slow one step. When fast reaches the end, slow is at the midpoint. Split the list into two halves: the first half from head to just before slow, and the second from slow->next to the end. Set slow->next to NULL.
Apply MergeSort Recursively: Recursively call MergeSort() on both halves. The base case is when the list is empty (head == NULL) or has one node (head->next == NULL), in which case return the list as is.
Merge the Two Sorted Halves: After sorting both halves, call merge() to merge them by comparing nodes and linking accordingly. Append any remaining nodes from the exhausted half. Finally, returns the new head of the sorted list.





🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/merge-sort-for-linked-list/
*/
/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
        // code here
        static Node split(Node head) {
        Node fast = head;
        Node slow = head;

        // Move fast pointer two steps and slow pointer
        // one step until fast reaches the end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        // Split the list into two halves
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

    // Function to merge two sorted singly linked lists
    static Node merge(Node first, Node second) {
      
        // If either list is empty, return the other list
        if (first == null) return second;
        if (second == null) return first;

        // Pick the smaller value between first and second nodes
        if (first.data < second.data) {
          
            // Recursively merge the rest of the lists and
            // link the result to the current node
            first.next = merge(first.next, second);
            return first;
        }
        else {
            // Recursively merge the rest of the lists
            // and link the result to the current node
            second.next = merge(first, second.next);
            return second;
        }
    }

    // Function to perform merge sort on a singly linked list
    static Node mergeSort(Node head) {
      
        // Base case: if the list is empty or has only one node, 
        // it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        Node second = split(head);

        // Recursively sort each half
        head = mergeSort(head);
        second = mergeSort(second);

        // Merge the two sorted halves
        return merge(head, second);
    }
    }
}