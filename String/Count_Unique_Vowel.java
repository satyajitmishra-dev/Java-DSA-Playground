/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

You are given a lowercase string s, determine the total number of distinct strings that can be formed using the following rules:
Identify all unique vowels (a, e, i, o, u) present in the string.
For each distinct vowel, choose exactly one of its occurrences from s. If a vowel appears multiple times, each occurrence represents a unique selection choice.
Generate all possible permutations of the selected vowels. Each unique arrangement counts as a distinct string
Return the total number of such distinct strings.

Example:
Input: s = "aeiou"
Output: 120
Explanation: Each vowel appears once, so the number of different strings can form is 5!=120.

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

Imagine you have a bag of letters (your string s), and you want to pick out only the vowels. Then, you want to arrange these selected vowels into unique sequences. The trick is that if you have, say, two 'a's, picking the first 'a' is considered different from picking the second 'a' for forming your unique string.

The Core Idea: Distinct Vowel Types and Their Choices
We'll break down the problem into two main parts:
Identify the types of unique vowels present: This tells us how many "slots" we have for our permutation (e.g., if 'a', 'e', 'i' are present, we have 3 slots).
Account for the number of choices for each vowel type: If 'a' appears twice, we have 2 ways to pick an 'a'. If 'e' appears once, we have 1 way to pick an 'e'.
The total number of distinct strings will be the factorial of the number of unique vowel types, multiplied by the count of each individual unique vowel occurrence.

Step-by-Step Approach
Let's walk through an example with s = "aaei":

Initialization:
vowelOccurrences = {} (A map to store counts of 'a', 'e', 'i', 'o', 'u')

Phase 1: Count Vowel Occurrences in s
Iterate through s = "aaei":
'a': vowelOccurrences['a'] = 1
'a': vowelOccurrences['a'] = 2
'e': vowelOccurrences['e'] = 1
'i': vowelOccurrences['i'] = 1
After iteration: vowelOccurrences = {'a': 2, 'e': 1, 'i': 1}

Phase 2: Determine Number of Unique Vowel Types

Count the number of distinct keys in vowelOccurrences.
uiqueVowelTypesCount = vowelOccurrences.size() (which is 3, for 'a', 'e', 'i').
Phase 3: Calculate Base Permutations of Vowel Types

This is the factorial of uniqueVowelTypesCount.
permutationsOfTypes = factorial(3) = 3 \times 2 \times 1 = 6.
These 6 permutations represent arrangements like (a, e, i), (a, i, e), (e, a, i), etc., where each 'a', 'e', 'i' is treated as a distinct placeholder for now.
Phase 4: Incorporate Choices for Each Vowel Occurrence

For each unique vowel type, we multiply by its count from vowelOccurrences. This accounts for the "unique selection choice" rule.
totalDistinctStrings = permutationsOfTypes (which is 6)
Multiply by count of 'a': totalDistinctStrings = 6 \times vowelOccurrences['a'] = 6 \times 2 = 12.
Multiply by count of 'e': totalDistinctStrings = 12 \times vowelOccurrences['e'] = 12 \times 1 = 12.
Multiply by count of 'i': totalDistinctStrings = 12 \times vowelOccurrences['i'] = 12 \times 1 = 12.
Final totalDistinctStrings = 12.

Why the multiplication by individual vowel counts? 🤔
This is the most crucial part of understanding the problem statement: "If a vowel appears multiple times, each occurrence represents a unique selection choice."
Consider s = "aa".
Unique vowel types: 'a' (1 type).

unqueVowelTypesCount = 1.
permutationsOfTypes = factorial(1) = 1.
Occurrences of 'a': 2.
Total distinct strings = 1 * count('a') = 1 * 2 = 2.
The two distinct strings are:
Choosing the first 'a' (at index 0)
Choosing the second 'a' (at index 1)

If the string was s = "aae", the unique vowel types are 'a' and 'e'. uniqueVowelTypesCount = 2.
permutationsOfTypes = factorial(2) = 2.
The permutations of the types are: (a, e) and (e, a).

Now, consider the choices for 'a' (2 occurrences) and 'e' (1 occurrence):
For (a, e):
Pick 1st 'a', then 'e' -> "ae" (using s[0])
Pick 2nd 'a', then 'e' -> "ae" (using s[1])
For (e, a):
Pick 'e', then 1st 'a' -> "ea" (using s[0])
Pick 'e', then 2nd 'a' -> "ea" (using s[1])
This gives us 2 distinct "ae" strings and 2 distinct "ea" strings, totaling 4 strings.
Using our formula: factorial(2) * count('a') * count('e') = 2 * 2 * 1 = 4.

This confirms that we multiply the base permutations by the count of each unique vowel to account for the distinct selection choices for each occurrence.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {

    // Helper function to calculate factorial
    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int vowelCount(String s) {
        // Step 1: Identify unique vowels and their occurrences
        Map<Character, Integer> vowelOccurrences = new HashMap<>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelOccurrences.put(ch, vowelOccurrences.getOrDefault(ch, 0) + 1);
            }
        }

        // Step 2: Get the count of distinct vowel types present
        int uniqueVowelTypesCount = vowelOccurrences.size();

        // If no vowels are present, no strings can be formed
        if (uniqueVowelTypesCount == 0) {
            return 0;
        }

        // Step 3: Calculate permutations of unique vowel types
        // This gives us the base number of arrangements for the *types* of vowels
        long permutationsOfTypes = factorial(uniqueVowelTypesCount);

        // Step 4: Multiply by the number of choices for each specific vowel type
        // This accounts for the distinct occurrences of each vowel type
        long totalDistinctStrings = permutationsOfTypes;
        for (int count : vowelOccurrences.values()) {
            totalDistinctStrings *= count;
        }

        // The problem asks for int return type, so cast the long result
        return (int) totalDistinctStrings;
    }
}