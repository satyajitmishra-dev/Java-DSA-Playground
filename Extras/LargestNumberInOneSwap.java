/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++
// Problem Statement : Largest number in one swap (GFG  , Easy)

Given a string s, return the lexicographically largest string that can be obtained by swapping at most one pair of characters in s.

Examples:

Input: s = "768"
Output: "867"
Explanation: Swapping the 1st and 3rd characters(7 and 8 respectively), gives the lexicographically largest string.

Input: s = "333"
Output: "333"
Explanation: Performing any swaps gives the same result i.e "333".

Constraints:
1 ≤ |s| ≤ 105
'0' ≤ s[i] ≤ '9'

++++++++++++++++++++++++++++++++  APPROACH ++++++++++++++++++++++++++++++++++++++++++++++++++
Since only one swap is allowed, we should make the leftmost digit as large as possible.

So, while traversing from right to left, we keep track of the maximum digit seen so far. If we find a smaller digit before it, that’s our candidate for swapping. At the end, we swap the leftmost smaller digit with the rightmost largest digit.

This ensures the first position where the number can be improved is maximized. If no such swap exists, the number is already the largest.

Step By Step Implementations:

Traverse the string from right to left, keeping track of:
-> maxDigit: the largest digit seen so far.
-> maxIndx: its index.
If the current digit is smaller than maxDigit, mark it as a candidate for swapping (l, r).
-> Since we go right-to-left, this ensures we pick the leftmost smaller digit with the best possible swap.
If no such pair is found, the number is already the largest.
Otherwise, perform the swap and return the new string

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/dsa/largest-number-with-one-swap-allowed/
*/

class Solution {
    public String largestSwap(String s) {
        // code here
        char[] arr = s.toCharArray();   // Convert the string into a character array so we can swap digits
char maxDigit = '0';            // Keeps track of the maximum digit found while scanning
int maxIndx = -1;               // Stores the index of the maximum digit
int l = -1, r = -1;             // These will store the positions of digits we want to swap

// Traverse the array from right to left
for (int i = arr.length - 1; i >= 0; i--) {

    // If the current digit is greater than the maxDigit seen so far,
    // update maxDigit and remember its index
    if (arr[i] > maxDigit) {
        maxDigit = arr[i];
        maxIndx = i;
    }
    // If the current digit is smaller than the maxDigit,
    // then swapping it with maxDigit will make the number bigger
    else if (arr[i] < maxDigit) {
        l = i;        // position of the smaller digit
        r = maxIndx;  // position of the larger digit (to swap with)
    }
}

// If no swap was found (number is already the largest), just return original string
if (l == -1) return s;

// Otherwise, swap the two digits
char temp = arr[l];
arr[l] = arr[r];
arr[r] = temp;

// Convert the character array back to a string and return
return new String(arr);

    }
}