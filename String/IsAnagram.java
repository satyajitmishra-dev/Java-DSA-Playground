class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // If lengths are not equal, they can't be anagrams
        if (s1.length() != s2.length()) return false;

        // Create a HashMap to count characters in s1
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character in s1
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        // Decrease count based on characters in s2
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            // If character not found or count becomes negative, not an anagram
            if (!map.containsKey(ch)) return false;

            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) < 0) return false;
        }

        // All counts are balanced — strings are anagrams
        return true;
    }
}
