/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Parenthesis Checker
 (Easy -- GFG Also Leetcode)

 Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:

         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.

Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.

Input: s = "([]"
Output: false
Explanation: The expression is not balanced as there is a missing ')' at the end.

Input: s = "([{]})"
Output: false
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.

Constraints:
1 ≤ s.size() ≤ 106
s[i] ∈ {'{', '}', '(', ')', '[', ']'}

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
// Approach : Using Stack


Intuition
The core idea is that when you encounter an opening bracket like (, {, or [, you anticipate a specific matching closing bracket, like ), }, or ], to appear later. The stack is perfect for this because it allows you to "remember" the expected closing bracket.

When you see (, you know you'll need a ). When you see another (, you'll need another ). If you then encounter a ), it must match the most recently seen, and therefore most recently "pushed," opening bracket. This is a perfect use case for a stack.

The st.push(')') part of your code is the clever trick. Instead of pushing the opening bracket itself, you push the expected closing bracket. This makes the later comparison very straightforward.

Approach :: ---->

Initialize an empty stack: A Stack<Character> st is created to store the expected closing brackets.

Iterate through the string: The code loops through each character ch of the input string s.

Handle opening brackets:

If ch is an opening bracket ((, {, or [), the corresponding closing bracket is pushed onto the stack. For example, if ch is (, you push ) onto the stack. This "marks" that you are waiting for a ) to close the current parenthesis.

Handle closing brackets:

If ch is a closing bracket (), }, or ]), you need to check if it's a valid match.

First, you check if the stack is empty. If it is, it means you've encountered a closing bracket without a corresponding opening bracket. This is an invalid sequence, so you immediately return false. For example, a string like ) would trigger this.

If the stack is not empty, you pop() the top character from the stack. This is the last-seen expected closing bracket.

You then compare this popped character with the current character ch. If they do not match, it means the closing bracket is incorrect (e.g., a ) trying to close a [). In this case, the string is invalid, so you return false.

Final Check:

After the loop finishes, you check if the stack is empty.

If the stack is empty, it means every opening bracket found had a corresponding closing bracket that was correctly matched and popped from the stack. The string is valid, and you return true.

If the stack is not empty, it means there are still unmatched opening brackets. For example, a string like (( would leave two ) characters on the stack at the end. In this case, the string is invalid, and you return false.

🌐 Resource (ctrl + click) :: https://leetcode.com/problems/valid-parentheses/submissions/1512350386


*/
//++++++++++++++++++++++++++++++++  CODE ++++++++++++++++++++++++++++++++++++++++++++++++++

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        // Traverse each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                st.push(')');
            else if (ch == '{')
                st.push('}');
            else if (ch == '[')
                st.push(']');
                else if(st.isEmpty() || st.pop() != ch) return false; // If current char is closing bracket, check for match
                
        }
        // If stack is empty, all brackets were matched correctly
        return st.isEmpty();
    }
}

// Time Complexity: O(n) where n is the length of the string. We traverse the string once.
// Space Complexity: O(n) in the worst case when all characters are opening brackets, we store them in the stack.   
// Auxiliary Space: O(1) if we consider the stack space for storing brackets as not part of the input size.