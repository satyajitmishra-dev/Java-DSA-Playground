/* 
++++++++++++++++++++++++++++++++  QUESTION & EXAMPLE  ++++++++++++++++++++++++++++++++++++++++++++++++++

You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples :
Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.

++++++++++++++++++++++++++++++++  APPROACH   ++++++++++++++++++++++++++++++++++++++++++++++++++

# Binary Search 
The minimum distance between the cows has a monotonic property.

If we can place all the cows with a minimum distance d, then we can also place them with any smaller distance than d. The reason is by reducing the minimum gap, we can place more number of cows as lower gaps allow us to place cows even more closer.

If we can't place all the cows with a minimum distance d, then we can't place them with any larger distance than d. The reason is if the gap is already too large to place the cows, then larger gap will also not work.
Therefore, we can use binary search to find the maximum possible minimum distance, and to check the for any distance, we place the first cow in the first stall and the next ones only if the gap from the last placed cow is at least that distance. If all cows can be placed for a certain distance, then it is a feasible distance.

🌐 Resource (ctrl + click) :: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/searching-gfg-160/article/OTAwNDc3

*/


import java.util.Arrays;

class Solution {
    public static boolean checkStalls(int[] stalls, int k, int dist) {
        int cnt = 1; // First cow is placed at stalls[0]
        int prev = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - prev >= dist) {
                prev = stalls[i];
                cnt++;
            }
        }
        return (cnt >= k);
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int ans = 0;
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (checkStalls(stalls, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
