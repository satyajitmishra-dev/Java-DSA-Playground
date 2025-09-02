/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Swap Kth Nodes from end (GFG  , Medium)

Given the head of a singly linked list and an integer k. Swap the kth node (1-based index) from the beginning and the kth node from the end of the linked list. Return the head of the final formed list and if it's not possible to swap the nodes return the original list.

Examples:

Input: k = 1,
  
Output: 5 -> 2 -> 3 -> 4 -> 1
Explanation: Here k = 1, hence after swapping the 1st node from the beginning and end the new list will be 5 -> 2 -> 3 -> 4 -> 1.
  
Input: k = 2,
  
Output: 5 -> 9 -> 8 -> 5 -> 10 -> 3
Explanation: Here k = 2, hence after swapping the 2nd node from the beginning and end the new list will be 5 -> 9 -> 8 -> 5 -> 10 -> 3.
  
Constraints:
1 ≤ list size ≤ 104
1 ≤ node->data ≤ 106
1 ≤ k ≤ 104



++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

🧠 Intuition (Beginner-Friendly)

Understand the kth node from start and end

kth from start = move k-1 steps from the head.

kth from end = move (n-k) steps from the head, where n = length of list.

Example: List = 1 → 2 → 3 → 4 → 5, n=5

k=2:

2nd node from start = 2

2nd node from end = 4

After swap → 1 → 4 → 3 → 2 → 5

When swap is NOT needed

If k > n (list has fewer nodes than k).

If kth from start and kth from end are the same node (middle node in odd-length list).

How to swap in a linked list?
Unlike arrays, we cannot directly swap values by index. We must handle pointers (next) carefully.
Steps:

Find the two nodes (x and y) and their previous nodes (prevX and prevY).

Adjust prevX.next and prevY.next to point to the swapped nodes.

Finally, swap their next links.

If one of them is the head, update the head.

📝 Algorithm

Count the number of nodes in the list (n).

Check edge cases:

If k > n, return list as is.

If 2*k - 1 == n → kth node from start = kth node from end → no swap needed.

Find kth node from start (x) and its previous (prevX).

Find kth node from end (y) and its previous (prevY).

Adjust previous pointers:

If prevX exists → prevX.next = y.

If prevY exists → prevY.next = x.

Swap next pointers of x and y.

Update head if needed:

If k == 1 → head = y.

If k == n → head = x.

Return the head.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/


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
    public Node swapKth(Node head, int k) {
        // If list is empty, nothing to do
        if (head == null) return head;

        // Step 1: Find the length of the linked list
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Step 2: If k is more than the size of list, no swap possible
        if (k > n) return head;

        // Step 3: If the kth node from start and kth from end are the same node, no swap
        if (2 * k - 1 == n) return head;

        // Step 4: Find the kth node from the beginning (x) and its previous node (prevX)
        Node prevX = null;
        Node x = head;
        for (int i = 1; i < k; i++) {
            prevX = x;
            x = x.next;
        }

        // Step 5: Find the kth node from the end (y) and its previous node (prevY)
        Node prevY = null;
        Node y = head;
        for (int i = 1; i < n - k + 1; i++) {
            prevY = y;
            y = y.next;
        }

        // Step 6: Change previous pointers to point to swapped nodes
        if (prevX != null) prevX.next = y;
        if (prevY != null) prevY.next = x;

        // Step 7: Swap the "next" pointers of x and y
        Node tempNext = x.next;
        x.next = y.next;
        y.next = tempNext;

        // Step 8: Fix head if we swapped the first or last node
        if (k == 1) head = y;   // If we swapped first node, head becomes y
        if (k == n) head = x;   // If we swapped last node, head becomes x

        return head; // Return new head
    }
}

