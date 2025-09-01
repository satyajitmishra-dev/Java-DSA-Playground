/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Min Stack (Leetcode [155] , Medium)

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++

Approach Step by Step
1. Push Operation

If the stack is empty → push normally and set min = val.

If val >= min → push normally.

If val < min →

We need to update the minimum.

Instead of pushing val, we push a **special encoded value = 2*val - min`.

Then update min = val.

👉 Why?
That encoded value is always smaller than the new min.
So later, when we see such a value during pop, we’ll know it represents a “marker” for the previous minimum.

2. Pop Operation

If top >= min → it’s a normal value, just pop.

If top < min → this means it’s one of those encoded values.

We need to restore the previous min.

Formula: oldMin = 2*min - top.

Then set min = oldMin and pop.

👉 This works because of how we encoded during push.

3. Top Operation

If top >= min → normal value, return top.

If top < min → means this is an encoded marker, so the actual value was the current min.

4. GetMin Operation

Just return the current min.

# Example Walkthrough
Push(5)

Stack empty → push(5), min = 5
Stack = [5], min = 5

Push(3)

val < min → push(2*3 - 5 = 1), min = 3
Stack = [5, 1], min = 3

Push(7)

val > min → push(7)
Stack = [5, 1, 7], min = 3

Pop()

top = 7 ≥ min → normal pop
Stack = [5, 1], min = 3

Pop()

top = 1 < min → encoded value

oldMin = 2*3 - 1 = 5

set min = 5, pop
Stack = [5], min = 5

✅ Correctly restored old min!

Key Intuition

Encode the previous minimum inside the stack when pushing a new smaller element.

Decode it back when popping.

That’s how we always keep track of min in O(1).

🌐 Resource (ctrl + click) :: Leetcode solutions, google


*/

class MinStack {
    Stack<Integer> st = new Stack<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            min = val;
        }
        if (min > val) {
            st.push(2*val - min);
            min = val;
        }
        if (min <= val) {
            st.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;
        if (st.peek() >= min)
            st.pop();
        else {
            min = 2*min - st.peek();
            st.pop();
        }
    }

    public int top() {
        if (st.isEmpty())
            return -1;
        if (st.peek() >= min) {
            return st.peek();
        }
        if (st.peek() < min){
            return min; 
        }
        return min;      
    }

    public int getMin() {
        return min;
    }
}

