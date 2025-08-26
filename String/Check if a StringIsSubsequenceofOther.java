/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement:  Check if a String is Subsequence of Other

// Difficulty Level : Easy(GFG)

Given two strings s1 and s2. You have to check that s1 is a subsequence of s2 or not.
Note: A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.

Examples:

Input: s1 = "AXY", s2 = "YADXCP"
Output: false
Explanation: s1 is not a subsequence of s2 as 'Y' appears before 'A'.

Input: s1 = "gksrek", s2 = "geeksforgeeks"
Output: true
Explanation: If we combine the bold character of "geeksforgeeks", it equals to s1. So s1 is a subsequence of s2. 

Constraints:
1 ≤ s1.size(), s2.size() ≤ 106

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
The idea is to use two pointers, one pointer will start from start of s1 and another will start from start of s2. If current character on both the indexes are same then increment both pointers otherwise increment the pointer which is pointing s2.

Follow the steps below to solve the problem:

Initialize the pointers i and j with zero, where i is the pointer to s1 and j is the pointer to s2.
If s1[i] = s2[j] then increment both i and j by 1.
Otherwise, increment only j by 1.
If i reaches the end of s1 then return true else return false. 


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/given-two-strings-find-first-string-subsequence-second/


*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

import java.io.*;

class Solution {

    static boolean isSubSeq(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j))
                i++;
            j++;
        }
        /*If i reaches end of s1,that mean we found all
        characters of s1 in s2,
        so s1 is subsequence of s2, else not*/
        return i == n;
    }
}

// Time Complexity: O(n) where m and n are lengths of s1 and s2 respectively.
// Space Complexity: O(1) as no extra space is used.
