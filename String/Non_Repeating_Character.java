class Solution {
    static char nonRepeatingChar(String s) {
        // Create a map to store frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Step 1: Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Step 2: Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i); // First non-repeating character
            }
        }

        // If no non-repeating character is found, return '$'
        return '$';
    }
}
