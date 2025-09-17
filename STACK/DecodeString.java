/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Decode String (GFG  , Medium)

Given an encoded string s, decode it by expanding the pattern k[substring], where the substring inside brackets is written k times. k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets. Return the final decoded string.

Note: The test cases are generated so that the length of the output string will never exceed 105 .

Examples:

Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
Inner substring “2[ca]” breakdown into “caca”.
Now, new string becomes “3[bcaca]”
Similarly “3[bcaca]” becomes “bcacabcacabcaca” which is final result.
Input: s = "3[ab]"
Output: "ababab"
Explanation: The substring "ab" is repeated 3 times giving "ababab".
Constraints:
1 ≤ |s| ≤ 105 
1 ≤ k ≤ 100

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
This problem is about decoding strings with the format like:

"3[a]2[bc]" → "aaabcbc"

"3[a2[c]]" → "accaccacc"

👉 The rule is:

A number followed by [ ... ] means repeat the inside substring that many times.

How the Code Works

Use a stack

We use a stack to temporarily store characters because it works in LIFO (Last-In-First-Out) order, which helps us handle nested patterns (like "2[ab3[c]]").

Process character by character

If the character is not ], push it into the stack.

If it is ], it means we’ve reached the end of a substring and need to decode it.

Decoding process when ] is found

Pop characters until we reach '['. This gives us the substring to repeat.

Then pop digits (like 3, 10, 25) before the '['. This tells us how many times to repeat.

Repeat the substring that many times and push it back onto the stack.

Final result

After processing the entire string, the stack has all characters of the decoded string.

Pop them all and reverse (since stack pops in reverse order).

✅ Example Walkthrough:

Input: "3[a2[c]]"

Push until ]: stack = [3, [, a, 2, [, c]

Found ] → pop until [ → substring = "c"

Number = 2 → repeat "cc" → push → stack = [3, [, a, cc]

Again found ] → substring = "acc"

Number = 3 → repeat "accaccacc" → push

Final string = "accaccacc" ✅

👉 Why stack?
Because we don’t know how deep the nesting is. Stack allows us to handle inner brackets before outer ones automatically (like recursion).

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/decode-string-recursively-encoded-count-followed-substring/
*/

class Solution {
    static String decodeString(String s) {
        // Create a stack to store characters during processing
        Stack<Character> st = new Stack<>();
        
        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            
            // Case 1: If the current character is NOT ']', push it into the stack
            // This includes letters, digits, and '['
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i));
            } 
            
            // Case 2: If we find a ']', then it's time to decode
            else {
                StringBuilder temp = new StringBuilder();
                
                // Step 1: Pop all characters until we find '['
                // These characters form the substring we need to repeat
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.append(st.pop());
                }
                
                // Reverse the substring because stack pops in reverse order
                temp.reverse();
                
                // Pop the '[' itself (we don't need it anymore)
                st.pop(); 

                StringBuilder num = new StringBuilder();
                
                // Step 2: Extract the number (the repeat count) from the stack
                // Digits may be more than one (like "12[ab]")
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.insert(0, st.pop());
                }
                
                // Convert the string number into an integer
                int number = Integer.parseInt(num.toString()); 
                
                // Step 3: Repeat the substring 'number' times
                StringBuilder repeat = new StringBuilder();
                for (int j = 0; j < number; j++)
                    repeat.append(temp);
                
                // Step 4: Push the repeated substring back onto the stack
                for (char c : repeat.toString().toCharArray())
                    st.push(c);
            }
        }

        // After finishing the loop, stack contains the full decoded string
        StringBuilder res = new StringBuilder();
        
        // Pop everything from stack to build the result
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        
        // Reverse to restore correct order (because popping reverses it)
        res.reverse();
        return res.toString();
    }
}

