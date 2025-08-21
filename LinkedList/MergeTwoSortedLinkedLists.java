/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement:Merge two sorted linked lists

Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.

Examples:

Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:

Input: head1 = 1 -> 1, head2 = 2 -> 4
Output: 1 -> 1 -> 2 -> 4
Explanation:

Constraints:
1 <= list1.size, list2.size <= 103
0 <= node->data <= 105

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

Algorithm

Key idea (intuition)

Keep one finger (temp1) on list-1 and one finger (temp2) on list-2.

At each step, pick the smaller node, attach it to the tail of the merged list, and move that finger forward.

When one list runs out, attach the rest of the other list.

A dummy node makes it easy to start the merged list without special cases.

Step-by-step approach

Create a dummy node

Node dummy = new Node(-1);

This is not part of the real answer; it just gives us a safe place to start building.

Keep a temp pointer that always points to the last node of the merged list: temp = dummy.

Initialize pointers to both lists

temp1 = head1; temp2 = head2;

Walk both lists while both have nodes

Loop: while (temp1 != null && temp2 != null)

Compare current values:

If temp1.data <= temp2.data, link temp.next = temp1 and move temp1 = temp1.next.

Else, link temp.next = temp2 and move temp2 = temp2.next.

Move temp = temp.next to keep it at the tail.

Attach whatever is left

After the loop, at least one list is empty.

If temp1 still has nodes, set temp.next = temp1.

If temp2 still has nodes, set temp.next = temp2.

Return the merged list head

The real head is right after dummy: return dummy.next;

🌐 Resource (ctrl + click) :: https://www.youtube.com/watch?v=FrGKsNBaq_4&t=8350s
🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/merge-two-sorted-linked-lists/


*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++
/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        Node dummy = new Node(-1);
        
        Node temp1 = head1, temp2 = head2, temp = dummy;
        
        while(temp1 != null && temp2 != null){
            if(temp1.data <= temp2.data){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        // If one of the lists is exhausted, append the other list
        // to the end of the merged list    
        if(temp2 == null){
            temp.next = temp1;
        }
        if(temp1 == null){
            temp.next = temp2;
        }
        return dummy.next;
    }
}

// Time Complexity: O(n + m), where n and m are the lengths of the two linked lists.
// Space Complexity: O(1), since we are not using any extra space except for the