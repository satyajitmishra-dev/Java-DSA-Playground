/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples:

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
Output: 4
Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

Brute-force Approach: 

A straightforward but basic solution is to examine consecutive sequences for each element in the given array. For every element x, we will try to find the consecutive elements, x+1, x+2, x+3, and so on using the linear search algorithm. Thus, we will check the length of the longest consecutive subsequence we can build for every element x. Among all the lengths we will consider the maximum one.

Algorithm:
To begin, we will utilize a loop to iterate through each element one by one.
Next, for every element x, we will try to find the consecutive elements like x+1, x+2, x+3, and so on using the linear search algorithm in the given array.
Within a loop, our objective is to locate the next consecutive element x+1. 
If this element is found, we increment x by 1 and continue the search for x+2. 
Furthermore, we increment the length of the current sequence (cnt) by 1. 
This process repeats until step 2.2 occurs.

If a specific consecutive element, for example, x+i, is not found, we will halt the search for subsequent consecutive elements such as x+i+1, x+i+2, and so on. Instead, we will take into account the length of the current sequence (cnt).
Among all the lengths we get for all the given array elements, the maximum one will be the answer.


Optimal Approach(Using Set data structure): 
We will adopt a similar approach to the brute-force method but with optimizations in the search process. Instead of searching sequences for every array element as in the brute-force approach, we will focus solely on finding sequences only for those numbers that can be the starting numbers of the sequences. This targeted approach narrows down our search and improves efficiency.

We will do this with the help of the Set data structure.

How to identify if a number can be the starting number for a sequence:

First, we will put all the array elements into the set data structure.
If a number, num, is a starting number, ideally, num-1 should not exist. So, for every element, x, in the set, we will check if x-1 exists inside the set. :
If x-1 exists: This means x cannot be a starting number and we will move on to the next element in the set.
If x-1 does not exist: This means x is a starting number of a sequence. So, for number, x, we will start finding the consecutive elements.
How to search for consecutive elements for a number, x:

Instead of using linear search, we will use the set data structure itself to search for the elements x+1, x+2, x+3, and so on.
Thus, using this method we can narrow down the search and optimize the approach.

Algorithm:
We will declare 2 variables, 

‘cnt’ → (to store the length of the current sequence), 
‘longest’ → (to store the maximum length).
First, we will put all the array elements into the set data structure.
For every element, x, that can be a starting number(i.e. x-1 does not exist in the set) we will do the following:
We will set the length of the current sequence(cnt) to 1.
Then, again using the set, we will search for the consecutive elements such as x+1, x+2, and so on, and find the maximum possible length of the current sequence. This length will be stored in the variable ‘cnt’.
After that, we will compare ‘cnt’ and ‘longest’ and update the variable ‘longest’ with the maximum value (i.e. longest = max(longest, cnt)).
Finally, we will have the answer i.e. ‘longest’.

🌐 Resource (ctrl + click) :: https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/

 */

// Brute-force Approach

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public boolean linearSearch(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x) return true; 
        }
        return false;
    }
    public int longestConsecutive(int[] arr) {
        // code here
        int maxCount = 0;
        
        for(int i = 0; i < arr.length; i++){
            int x = arr[i];
            
            int count = 1;
            
            while(linearSearch(arr, x + 1)== true){
                x++;
                count++;
            }
        maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}


// Optimal Approach (Using Set data structure)

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int maxCount = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int ele : arr){
            set.add(ele);
        }
        
        for(int ele : set){
            if(!set.contains(ele - 1)){
                int count = 1;
                int x = ele;
                
                while(set.contains(x + 1)){
                    x++;
                    count++;
                }
        maxCount = Math.max(maxCount, count);
            }
        }
        
        return maxCount;
        }
    }