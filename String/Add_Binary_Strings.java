// User function Template for Java

class Solution {

    // Remove leading zeros from a binary string
    String removeLeadingZeros(String s){
        int firstOne = s.indexOf('1');
        return (firstOne == -1) ? "0" : s.substring(firstOne);
    }

    public String addBinary(String s1, String s2) {
        // Remove unnecessary leading zeros from both strings
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);

        int m = s1.length();
        int n = s2.length();

        // Ensure s1 is the longer string
        if(n > m){
            return addBinary(s2, s1);
        }

        int j = n - 1; // pointer for s2
        int carry = 0;
        StringBuilder ans = new StringBuilder();

        // Loop from end of s1 (the longer string)
        for(int i = m - 1; i >= 0; i--){
            int bit1 = s1.charAt(i) - '0'; // convert char to int
            int sum = bit1 + carry;

            // If s2 has bits left, add them
            if(j >= 0){
                int bit2 = s2.charAt(j) - '0';
                sum += bit2;
                j--;
            }

            int bit = sum % 2;        // result bit after addition
            carry = sum / 2;          // update carry

            ans.append((char)(bit + '0')); // convert int to char and append
        }

        // If there's a carry left, add it
        if(carry > 0){
            ans.append('1');
        }

        // Since we built the result in reverse, reverse it before returning
        return ans.reverse().toString();
    }
}
