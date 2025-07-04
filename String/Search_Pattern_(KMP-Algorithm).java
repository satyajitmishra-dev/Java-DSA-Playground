// User function Template for Java

class Solution {

    // Function to build the Longest Prefix Suffix (LPS) array
    static void constructlps(int[] lps, String pat) {
        int len = 0;         // length of the previous longest prefix suffix
        lps[0] = 0;          // lps[0] is always 0

        int i = 1;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Try to find a smaller prefix-suffix match
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Function to find all occurrences of pattern `pat` in text `txt`
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = pat.length();
        int m = txt.length();

        // Step 1: Construct the LPS array for the pattern
        int[] lps = new int[n];
        constructlps(lps, pat);

        // Step 2: Start matching using KMP algorithm
        int i = 0; // pointer for txt
        int j = 0; // pointer for pat

        while (i < m) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // If full pattern is matched
                if (j == n) {
                    ans.add(i - j);      // Add starting index of match
                    j = lps[j - 1];      // Reset j using LPS to find next match
                }
            } else {
                // Mismatch after j > 0 characters matched
                if (j != 0) {
                    j = lps[j - 1];      // Backtrack in pattern
                } else {
                    i++;                 // Move to next character in text
                }
            }
        }

        return ans; // Return list of starting indices where pattern matched
    }
}
