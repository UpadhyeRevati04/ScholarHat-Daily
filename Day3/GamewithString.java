package Day3;
import java.util.*;

class Solution {
    static int minValue(String str, int k) {
        // code here
        int[] charCounts = new int[26];
        for (char c : str.toCharArray()) {
            charCounts[c - 'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : charCounts) {
            if (count > 0) {
                pq.offer(count);
            }
        }

        for (int i = 0; i < k; i++) {
            int maxCount = pq.poll();
            if (maxCount > 0) {
                pq.offer(maxCount - 1);
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int count = pq.poll();
            result += count * count;
        }

        return result;
    }
}
