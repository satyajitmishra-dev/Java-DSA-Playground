/*
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

Given an array of strings, return all groups of strings that are anagrams. The strings in each group must be arranged in the order of their appearance in the original array. Refer to the sample case for clarification.

Examples:

1. Input: arr[] = ["act", "god", "cat", "dog", "tac"]
Output: [["act", "cat", "tac"], ["god", "dog"]]
Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.

2. Input: arr[] = ["no", "on", "is"]
Output: [["is"], ["no", "on"]]
Explanation: There are 2 groups of anagrams "is" makes group 1. "no", "on" make group 2.

3. Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"], ["rat", "tar", "art"]]
Explanation: 
Group 1: "abc", "bac", and "cab" are anagrams.
Group 2: "listen", "silent", and "enlist" are anagrams.
Group 3: "rat", "tar", and "art" are anagrams.

++++++++++++++++++++++++++++++++  APPROACH  ++++++++++++++++++++++++++++++++++++++++++++++++++

The idea is to that if two strings are anagrams of each other, then the frequency of all characters in both strings will always be the same. So, we can maintain a hash map with the count of characters as keys and the index of the anagram group in the result array as the value. For each word, we can first construct a frequency array of size 26 to store the frequency of each character in the word. Then, we can append the frequency of each character separated by a delimiter, say '$' to form the key for hash map. 

Note the MAX_CHAR is alphabet size of input characters which is typically a constant. If we have only lower case characters, then MAX_CHAR is 26 only. If we consider all ASCII characters, then MAX_CHAR is 256.


🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/article/MjYxMjU%3D


 */

class Solution {
    static final int MAX_CHAR = 26;
    public static String getHash(String s){
        StringBuilder hash = new StringBuilder();
        int[] frequency = new int[MAX_CHAR];
        
        for(char ch : s.toCharArray()){
            frequency[ch - 'a']++;
            
        }
        
        for(int i = 0; i < MAX_CHAR; i++){
            hash.append(frequency[i]);
            hash.append("$");
            
        }
        return hash.toString();
    }
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            String key = getHash(arr[i]);
            
            if(!map.containsKey(key)){
                map.put(key, ans.size());
                ans.add(new ArrayList<>());
            }
            
            ans.get(map.get(key)).add(arr[i]);
        }
        return ans;
    }
}
