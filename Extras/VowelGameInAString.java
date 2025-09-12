/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Vowel Game In a String (Leetcode  , Medium)

Alice and Bob are playing a game on a string.

You are given a string s, Alice and Bob will take turns playing the following game where Alice starts first:

On Alice's turn, she has to remove any non-empty substring from s that contains an odd number of vowels.
On Bob's turn, he has to remove any non-empty substring from s that contains an even number of vowels.
The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play optimally.

Return true if Alice wins the game, and false otherwise.

The English vowels are: a, e, i, o, and u.

 

Example 1:

Input: s = "leetcoder"

Output: true

Explanation:
Alice can win the game as follows:

Alice plays first, she can delete the underlined substring in s = "leetcoder" which contains 3 vowels. The resulting string is s = "der".
Bob plays second, he can delete the underlined substring in s = "der" which contains 0 vowels. The resulting string is s = "er".
Alice plays third, she can delete the whole string s = "er" which contains 1 vowel.
Bob plays fourth, since the string is empty, there is no valid play for Bob. So Alice wins the game.
Example 2:

Input: s = "bbcd"

Output: false

Explanation:
There is no valid play for Alice in her first turn, so Alice loses the game.

Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
Problem Insight

Alice can remove substrings with an odd number of vowels.

Bob can remove substrings with an even number of vowels (including 0).

Alice plays first.

The winner is the one who makes the last move.

Key Observation

If the string has no vowels, Alice cannot make the first move ⇒ Bob wins immediately.

If the string has at least one vowel, Alice can always win because:

She starts first and can always remove a substring with an odd number of vowels.

She can ensure Bob never removes the last vowel.

Eventually, Alice will take the last vowel and win.

Example 1

s = "baabbbba"

Total vowels = 3 (odd).

Alice removes the entire string on her first move.

Alice wins.

Example 2

s = "babbbabb"

Alice removes a substring with odd vowels (e.g., "ba" → leaves "bbbabb").

Bob removes a substring with even vowels (like "bb").

Eventually, only one vowel remains ("a").

Alice removes the last vowel and wins.

Final Conclusion

No vowels → Alice loses.

At least one vowel → Alice always wins.

Complexity

Time Complexity: O(n) (scan string to check for vowels).

Space Complexity: O(1) (constant extra space)


🌐 Resource (ctrl + click) :: internet
*/

class Solution {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++)
            if ((0x104111 >> (s.charAt(i) - 97) & 1) != 0)
                return true;
        return false;
    }
}