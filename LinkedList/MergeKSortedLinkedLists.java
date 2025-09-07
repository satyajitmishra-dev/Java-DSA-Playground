/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Merge K sorted linked lists (GFG  , Medium)


// 

Given an array arr[] of n sorted linked lists of different sizes. Your task is to merge all these lists into a single sorted linked list and return the head of the merged list.

Examples:

Input:
   
Output: 1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9
Explanation: The arr[] has 3 sorted linked list of size 3, 3, 1.
1st list: 1 -> 3 -> 7
2nd list: 2 -> 4 -> 8
3rd list: 9
The merged list will be: 
    
Input:
   
Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
Explanation: The arr[] has 3 sorted linked list of size 2, 1, 3.
1st list: 1 -> 3
2nd list: 8
3rd list: 4 -> 5 -> 6
The merged list will be: 
    
Constraints
1 ≤ total no. of nodes ≤ 105
1 ≤ node->data ≤ 103



++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

Algorithm / Intuition
The previous approach of merging two lists at a time, the number of operations grows exponentially with ‘k’ the number of lists in the list array. With a large number of lists, the number of redundant and repeated comparisons increases substantially affecting the overall efficiency.

To optimise the process of merging K sorted lists, we can utilise a min heap-based approach where we define a priority queue to maintain the sorted order based on node values. Push all the heads of all K linked lists into a priority queue.

While the priority queue is not empty, extract the head ie. node with the minimum value, append it to our merged list and push it’s next node into the priority queue.

This iterative process ensures that at each step, the algorithm selects the smallest available node value among the heads of the linked lists. This minimum value is appended to the merged list, and we then move to the next node from the same list for further merging until all lists are merged into a single sorted linked list.

Algorithm:
Initialise a priority queue such that each element is a pair/tuple consisting of an integer (int) representing the node’s data value and a pointer to the node

This is done because a priority queue maintains a collection of elements with a priority, allowing operations to access and manipulate the element with the highest (or lowest) priority efficiently.
Using a pair as its elements allows the priority queue to order elements in ascending order of the integer values ie. based on the node data.

Push the heads of all K linked lists into the priority queue.

Create a dummy node to build the merge list.
Iterate while the priority queue is not empty and extract from the top of the priority queue ie. node with the minimum node value.

If the current extracted node has a next node, push the next node into the priority queue and set the next pointer of the current node in the merged list.

Return the merged linked list starting from the next of the dummy nodes

🌐 Resource (ctrl + click) :: https://takeuforward.org/linked-list/merge-k-sorted-linked-lists
*/
class Solution {
    Node mergeKLists(Node[] arr) {
        // Min-heap based on node values
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));

        // Push all heads of linked lists into the priority queue
        for (Node node : arr) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy node to simplify merging
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Merge process
        while (!pq.isEmpty()) {
            Node curr = pq.poll();   // get node with smallest value

            // Push its next node (if exists) into heap
            if (curr.next != null) {
                pq.add(curr.next);
            }

            // Link the current smallest node to merged list
            temp.next = curr;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
