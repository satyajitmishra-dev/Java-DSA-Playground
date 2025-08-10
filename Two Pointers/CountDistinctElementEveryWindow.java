/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Count distinct elements in every window

Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is [1, 2, 1, 3]. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is [2, 1, 3, 4]. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is [1, 3, 4, 2]. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is [3, 4, 2, 3]. Number of distinct elements in this window are 3.

Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: Window 1 of size k = 2 is [4, 1]. Number of distinct elements in this window are 2.
Window 2 of size k = 2 is [1, 1]. Number of distinct elements in this window is 1. 

Input: arr[] = [1, 1, 1, 1, 1], k = 3
Output: [1, 1, 1]
Explanation: Every window of size 3 in the array [1, 1, 1, 1, 1], contains only the element 1, so the number of distinct elements in each window is 1.


++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to use Sliding Window Technique and count the number of distinct element in the current window using the count of previous window. Maintain a hash map or dictionary to store the frequency of elements of the current window and the count of distinct elements in the window will be equal to the size of the hash map.

Store the frequency of first k elements in the hash map. Now start iterating from index = k, 

increase the frequency of arr[k] in the hash map.
decrease the frequency of arr[i - k] in the hash map. If frequency of arr[i - k] becomes 0, remove arr[i] from the hash map.
insert size of hash map into the resultant array.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/count-distinct-elements-in-every-window-of-size-k/
*/

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Map <Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        ans.add(map.size());
        
        for(int i = k ; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            
            if(map.get(arr[i - k]) == 0){
                map.remove(arr[i - k]);
            }
            ans.add(map.size());
        }
        return ans;
    }
}