/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Linked List Group Reverse
// Difficulty Level : Hard(gfg & leetcode)

Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.

Examples:

Input: head = 1 -> 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5

Explanation: The first 4 elements 1, 2, 2, 4 are reversed first and then the next 4 elements 5, 6, 7, 8. Hence, the resultant linked list is 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5.
Input: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
Output: 3 -> 2 -> 1 -> 5 -> 4

Explanation: The first 3 elements 1, 2, 3 are reversed first and then left out elements 4, 5 are reversed. Hence, the resultant linked list is 3 -> 2 -> 1 -> 5 -> 4.
Constraints:
1 <= size of linked list <= 105
1 <= data of nodes <= 106
1 <= k <= size of linked list 

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

To reverse a linked list in groups of size k, the goal is to traverse the list in segments of k nodes and reverse each group individually. After reversing each group, we connect it to the previous group by updating the tail pointer. This process continues until the entire list is traversed, and we return the new head of the reversed list.

Follow the steps below to solve the problem:

Initialize pointers:
Set curr to the head of the list to start traversing.
Set newHead to NULL to track the new head after the first group reversal.
Set tail to NULL to connect the previous group to the current reversed group.
Traverse the list in groups of k:
For each group of k nodes, set groupHead to curr.
Reverse the nodes in the group by updating the next pointers, using prev and nextNode.
Connect the reversed group to the previous one:
After reversing, if tail is not nullptr, connect the previous group's end to the current reversed group’s head.
Update tail to point to the last node of the current group.
Repeat the process until all nodes in the list are processed, and return newHead, which points to the head of the fully reversed list

🌐 Resource (ctrl + click) :: https://www.youtube.com/watch?v=-swgIiMIlJo
🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/reverse-a-linked-list-in-groups-of-given-size-iterative-approach/


*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        
        Node current = head;
        Node newHead = null;
        Node tail = null;
        
        while(current != null){
            Node prevNode = null;
            Node nextNode = null;
            Node groupHead = current;
            int count = 0;
            
            while(current != null && count < k){
                nextNode = current.next;
                current.next = prevNode;
                prevNode = current;
                current = nextNode;
                count++;
            }
            
            if(newHead == null){
                newHead = prevNode;
            }
            if(tail != null){
                tail.next = prevNode;
            }
            
            tail = groupHead;
        }
        return newHead;
        
    }
}

// Time Complexity: O(N) where N is the number of nodes in the linked list. Each node is processed exactly once.
// Space Complexity: O(1) as we are using only a constant amount of extra space for pointers.