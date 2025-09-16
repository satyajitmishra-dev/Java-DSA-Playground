/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Postfix Evaluation (GFG  , Medium)

You are given an array of strings arr[] that represents a valid arithmetic expression written in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.

Note: A postfix expression is of the form operand1 operand2 operator (e.g., "a b +"). 
And the division operation between two integers always computes the floor value, i.e floor(5 / 3) = 1 and floor(-5 / 3) = -2.
It is guaranteed that the result of the expression and all intermediate calculations will fit in a 32-bit signed integer.

Examples:

Input: arr[] = ["2", "3", "1", "*", "+", "9", "-"]
Output: -4
Explanation: If the expression is converted into an infix expression, it will be 2 + (3 * 1) – 9 = 5 – 9 = -4.
Input: arr[] = ["2", "3", "^", "1", "+"]
Output: 9
Explanation: If the expression is converted into an infix expression, it will be 2 ^ 3 + 1 = 8 + 1 = 9.
Constraints:
3 ≤ arr.size() ≤ 103
arr[i] is either an operator: "+", "-", "*", "/" or "^", or an integer in the range [-104, 104]


++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
What is Postfix Expression?

Infix (normal math): 2 + 3

Postfix (Reverse Polish Notation): 2 3 +
👉 In postfix, the operator comes after the operands.
This removes the need for parentheses and makes evaluation easier.

2. How do we evaluate postfix?

We use a stack:

Read tokens left to right.

If it's a number, push it on the stack.

If it's an operator (+, -, *, /, ^):

Pop the top two numbers from the stack.

Apply the operator.

Push the result back on the stack.

At the end → the stack has one number → answer.

3. Example Walkthrough

Expression:
["2", "3", "1", "*", "+", "9", "-"]
(Equivalent to 2 + (3 * 1) - 9)

Step-by-step:

Read 2 → push → stack = [2]

Read 3 → push → stack = [2, 3]

Read 1 → push → stack = [2, 3, 1]

Read * → pop 1 and 3 → 3*1=3 → push → stack = [2, 3]

Read + → pop 3 and 2 → 2+3=5 → push → stack = [5]

Read 9 → push → stack = [5, 9]

Read - → pop 9 and 5 → 5-9=-4 → push → stack = [-4]

✅ Final result = -4

4. Why floorDiv?

In Java:

-3 / 2 = -1 (rounds toward 0)
But floor division should round down:

-3 / 2 = -2
That’s why we wrote a custom floorDiv.

📌 Common Mistakes Beginners Make

Forgetting order of popping:

First pop = right operand

Second pop = left operand

Otherwise, subtraction and division will give wrong answers.

Not handling negative numbers properly.
That’s why the code checks (token.length() > 1 && token.charAt(0) == '-').

Not using a stack: Some try arrays/lists, but stack is the natural fit here.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/evaluation-of-postfix-expression/
*/

class Solution {

    // Custom floor division (handles negative numbers properly)
    static int floorDiv(int a, int b) {
        // If signs of a and b are different (one positive, one negative)
        // AND the division leaves a remainder,
        // then normal integer division in Java rounds towards 0.
        // But in postfix evaluation, we want floor division (round down).
        if (a * b < 0 && a % b != 0)
            return (a / b) - 1;  
        return a / b;
    }
    
    public static int evaluatePostfix(String[] arr) {
        // Stack is used to store operands while evaluating postfix expression
        Stack<Integer> st = new Stack<>();

        for (String token : arr) {  
            // If the current token is a number, push it into the stack.
            // Example: "12" or "-5"
            if (Character.isDigit(token.charAt(0)) || 
                (token.length() > 1 && token.charAt(0) == '-')) {
                st.push(Integer.parseInt(token));
            } 
            // Otherwise, the token is an operator (+, -, *, /, ^)
            else {
                // Pop the top two elements from the stack
                int val1 = st.pop(); // first popped (right operand)
                int val2 = st.pop(); // second popped (left operand)

                // Perform the operation based on the operator
                if (token.equals("+")) st.push(val2 + val1);
                else if (token.equals("-")) st.push(val2 - val1);
                else if (token.equals("*")) st.push(val2 * val1);
                else if (token.equals("/")) st.push(floorDiv(val2, val1));
                else if (token.equals("^")) st.push((int)Math.pow(val2, val1));
            }
        }

        // At the end, the stack has only one element → the final result
        return st.pop();
    }
}
