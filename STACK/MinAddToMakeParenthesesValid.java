/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Min Add to Make Parentheses Valid (GFG  , Medium)

You are given a string s consisting only of the characters '(' and ')'. Your task is to determine the minimum number of parentheses (either '(' or ')') that must be inserted at any positions to make the string s a valid parentheses string.

A parentheses string is considered valid if:

Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
Every closing parenthesis ')' has a corresponding opening parenthesis '('.
Parentheses are properly nested.
Examples:

Input: s = "(()("
Output: 2
Explanation: There are two unmatched '(' at the end, so we need to add two ')' to make the string valid.

Input: s = ")))"
Output: 3
Explanation: Three '(' need to be added at the start to make the string valid.

Input: s = ")()()"
Output: 1 
Explanation: The very first ')' is unmatched, so we need to add one '(' at the beginning.

Constraints:
1 ≤ s.size() ≤ 105
s[i] ∈ { '(' , ')' }

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
What’s the problem?
We need to make a parentheses string valid by adding the minimum number of parentheses.
Example:
(() → needs 1 ) to become ()
())( → needs 2 insertions (())() or ()())

How does the solution work?
Use a stack to keep track of unmatched parentheses.

For each character:
If it’s '(', push it (waiting for a match).
If it’s ')':
If the top of stack has '(' → they match, so pop it.

Otherwise, push the ')' (since it’s unmatched).
At the end, whatever is still in the stack are unmatched parentheses.
→ That’s exactly how many insertions are needed.

Why stack?
Because parentheses matching is a last-in, first-out problem (the most recent open bracket must be closed first). Stack is the perfect data structure for this.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/minimum-number-of-parentheses-to-be-added-to-make-it-valid/#-1
*/

class Solution {
    public int minParentheses(String s) {
        // Stack is used to track unmatched parentheses
        Stack<Character> st = new Stack<>();
        
        // Traverse through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If stack is not empty, try to match
            if (!st.isEmpty()) {
                if (ch == '(') {
                    // If it's an opening bracket, push into stack
                    st.push('(');
                } 
                else if (st.peek() == '(') {
                    // If current is ')' and top of stack is '(' → valid pair
                    // So remove the matched '(' from stack
                    st.pop();
                } 
                else {
                    // If current is ')' but no '(' to match → unmatched ')'
                    st.push(ch);
                }
            } 
            else {
                // If stack is empty, simply push the bracket
                st.push(ch);
            }
        }
        
        // Remaining stack contains unmatched parentheses
        // The count of these gives the minimum insertions needed
        return st.size();
    }
}

