class Solution {
    public int myAtoi(String s) {
        int num = 0, sign = 1, idx = 0;

        // Skip leading whitespaces
        while (idx < s.length() && s.charAt(idx) == ' ') idx++;

        // Handle optional '+' or '-' sign
        if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            if (s.charAt(idx) == '-') sign = -1;
            idx++;
        }

        // Convert digits to number and check for overflow
        while (idx < s.length() && (s.charAt(idx) >= '0' && s.charAt(idx) <= '9')) {
            if (num > Integer.MAX_VALUE / 10 || 
               (num == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (s.charAt(idx++) - '0');
        }

        // Apply the sign and return the result
        return num * sign;
    }
}
