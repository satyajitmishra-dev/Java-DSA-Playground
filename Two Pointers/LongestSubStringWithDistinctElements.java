/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement: Longest substring with distinct characters


You are given a string s. You have to find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.

Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
// Approach: Sliding Window Technique

The idea is to maintain a window of distinct characters. The window is initialized as single character. We keep extending the window on the right side till we see distinct characters. When we see a repeating character, we remove characters from the left side of the window. We keep track of the maximum length window.

Below are the detailed steps:

Initialize two pointers left and right with 0, which define the current window being considered.
The right pointer moves from left to right, extending the current window.
If the character at right pointer is not visited, it's marked as visited.
If the character at right pointer is visited, it means there is a repeating character. The left pointer moves to the right while marking visited characters as false until the repeating character is no longer part of the current window.
The length of the current window (right - left + 1) is calculated and answer is updated accordingly.

🌐 Resource (ctrl + click) ::https://www.geeksforgeeks.org/dsa/length-of-the-longest-substring-without-repeating-characters/

*/

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        if(s.length() < 2) return s.length();
        int ans = 0;
        int left = 0, right = 0;
        // Array to keep track of visited characters
        // Assuming only lowercase letters a-z
        boolean[] visited = new boolean[26];
        // Iterate through the string with two pointers
        while(right < s.length()){
            // If the character at right pointer is already visited
            while(visited[s.charAt(right) - 'a'] == true){
                visited[s.charAt(left) - 'a'] = false;
                left++;
            }
            visited[s.charAt(right) - 'a'] = true;
            ans = Math.max(ans, (right - left + 1));
            right++;
        }
        return ans;
    }
}