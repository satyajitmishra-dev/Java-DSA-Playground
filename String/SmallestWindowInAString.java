/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Smallest window containing all characters (Hard -- GFG)

Given two strings s and p. Find the smallest substring in s consisting of all the characters (including duplicates) of the string p. Return empty string in case no such substring is present.
If there are multiple such substring of the same length found, return the one with the least starting index.

Examples:

Input: s = "timetopractice", p = "toc"
Output: "toprac"
Explanation: "toprac" is the smallest substring in which "toc" can be found.

Input: s = "zoomlazapzo", p = "oza"
Output: "apzo"
Explanation: "apzo" is the smallest substring in which "oza" can be found.

Input: s = "zoom", p = "zooe"
Output: ""
Explanation: No substring is present containing all characters of p.

Constraints: 

1 ≤ s.length(), p.length() ≤ 106
s, p consists of lowercase english letters



++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
The idea is to use Window Sliding (start and j) to maintain a sliding window over string S, while tracking character frequencies with two count arrays:

Initialize:
A count array to store the frequency of characters in P.
Another count array to track the characters in the current window of S.
Variables to track the minimum window length and its start index.
Expand the Window:
Move the j pointer through S, updating the window's character counts.
When all characters of P are present in the window, a valid window is found.
Shrink the Window before updating result
Move the start pointer right to minimize the window while ensuring all characters from P remain in the window.
Track the smallest window during this process.
Return Result:
If a valid window is found, return the smallest substring. If no valid window exists, return "-1".

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/


*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

class Solution {
    public static String smallestWindow(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();

        // GfG expects "" when no answer
        if (len1 < len2) return "";

        int[] countP = new int[256];
        int[] countS = new int[256];

        // frequency of chars in p
        for (int i = 0; i < len2; i++) countP[p.charAt(i)]++;

        int start = 0, start_idx = -1, min_len = Integer.MAX_VALUE;
        int matched = 0;

        for (int j = 0; j < len1; j++) {
            char curr = s.charAt(j);
            countS[curr]++;

            if (countP[curr] > 0 && countS[curr] <= countP[curr]) matched++;

            // when all required chars are matched, shrink from left
            if (matched == len2) {
                char sc;
                while (countS[sc = s.charAt(start)] > countP[sc] || countP[sc] == 0) {
                    if (countS[sc] > countP[sc]) countS[sc]--;
                    start++;
                }

                int winLen = j - start + 1;
                if (winLen < min_len) {
                    min_len = winLen;
                    start_idx = start;
                }
            }
        }

        if (start_idx == -1) return "";      // also "" if nothing found
        return s.substring(start_idx, start_idx + min_len);
    }
}
