/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : String Stack (GFG  , Medium)

You are given two strings pat and tar consisting of lowercase English characters. You can construct a new string s by performing any one of the following operation for each character in pat:

Append the character pat[i] to the string s.
Delete the last character of s (if s is empty do nothing).
After performing operations on every character of pat exactly once, your goal is to determine if it is possible to make the string s equal to string tar.

Examples:

Input: pat = "geuaek", tar = "geek"
Output: true
Explanation: Append the first three characters of pat to s, resulting in s = "geu". Delete the last character for 'a', leaving s = "ge". Then, append the last two characters 'e' and 'k' from pat to s, resulting in s = "geek", which matches tar.

Input: pat = "agiffghd", tar = "gfg"
Output: true
Explanation: Skip the first character 'a' in pat. Append 'g' and 'i' to s, resulting in s = "gi". Delete the last character for 'f', leaving s = "g". Append 'f', 'g', and 'h' to s, resulting in s = "gfgh". Finally, delete the last character for 'd', leaving s = "gfg", which matches tar.

Input: pat = "ufahs", tar = "aus"
Output: false
Explanation: It is impossible to construct the string tar from pat with the given operations.

Constraints:
1 ≤ pat.size(), tar.size() ≤ 105

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
There are two key things to notice in this problem:

Case 1 - Deleting a mismatch

If the current character doesn’t match the target (tar), we can’t just erase it alone. To remove this mismatch, we also need to delete the previous character (because delete always removes the last added one). So, handling a mismatch always consumes at least two characters from pat.

Case 2- Skipping with an empty string

If string is empty and we decide to "delete," nothing happens. This means some characters in pat can simply be ignored — they don’t harm if the string is empty at that moment.

Why start from the end?

If we check from the back, we can greedily try to match every character of tar.
Whenever characters align, we keep them.
If they don’t match, we simulate deletion (skip them in pairs).
Once all of tar is matched, any leftover characters at the front can just be skipped — they don’t affect the final result.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/string-stack/
*/

class Solution {
    public boolean stringStack(String pat, String tar) {
        // code here
        int i = pat.length() - 1, j = tar.length() - 1;
        
        while (i >= 0 && j >= 0) {
            
            // If characters don’t match, simulate a deletion 
            // by skipping previous character in 'pat'
            if (pat.charAt(i) != tar.charAt(j)) {
                i -= 2;
            } 
            
            // If characters match, move both pointers
            // to the previous character
            else {
                i--;
                j--;
            }
        }
        
        // If we have successfully matched
        // all characters of 'tar', return true
        return j < 0;
    }
}
