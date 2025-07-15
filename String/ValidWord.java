/* 
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
# Valid Word (Leetcode 3136) >

A word is considered valid if:
It contains a minimum of 3 characters.
It contains only digits (0-9), and English letters (uppercase and lowercase).
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.

Return true if word is valid, otherwise, return false.

# Notes:
'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
A consonant is an English letter that is not a vowel.
 
Example 1:
Input: word = "234Adas"
Output: true
Explanation:
This word satisfies the conditions.

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

First, we check whether the length of the given word is at least 3. Then, using a single traversal, we determine whether the word contains at least one vowel letter, at least one consonant letter, and only valid characters, i.e., letters and digits. Any other characters are not allowed.

🌐 Resource (ctrl + click) :: https://leetcode.com/problems/valid-word/solutions/6948995/valid-word/?envType=daily-question&envId=2025-07-15 


 */

class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        boolean hasVowel = false, hasConsonent = false;
        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                char c = Character.toLowerCase(ch);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonent = true;
                }
            } else if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return hasVowel && hasConsonent;
    }
}