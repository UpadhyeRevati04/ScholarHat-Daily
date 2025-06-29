## # Day 3 - Minimum Value of String After Removing K Characters

### 🔍 Problem Statement:

You are given a string `str` and an integer `k`.
In one operation, you can **remove any character** from the string. You can perform **at most `k` such operations**.

After the operations, the value of the string is defined as the **sum of squares of the frequencies** of each remaining character.

Your task is to **minimize** this total value after `k` removals.

---

### 🧾 Example:
Input:
str = "abccc"
k = 1

Output:
6

Explanation:
Removing one occurrence of 'c' results in the string "abcc".
The frequencies are:
a = 1, b = 1, c = 2 → value = 1² + 1² + 2² = 6
```

---

### 🧠 Intuition:

To minimize the total value, we need to reduce the frequency of the **most frequent character**, because squares grow faster than linearly.

Thus, in each step, we should remove **one instance** of the **character with the highest frequency**.

---

# ### 🧮 Logic:

1. Count the frequency of each character in the string.
2. Use a **max heap (priority queue in reverse order)** to always pick the character with the highest frequency.
3. For `k` times:

   * Remove one occurrence of the most frequent character.
4. After `k` operations, compute the sum of squares of the remaining frequencies.

---

### 👩‍💻 Code: `MinValueString.java`

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    static int minValue(String str, int k) {
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
---

### 🧪 Sample Input/Output:

| Input     | k | Output |
| --------- | - | ------ |
| `"abccc"` | 1 | 6      |
| `"aaab"`  | 2 | 2      |
| `"zzz"`   | 2 | 1      |

---

### ⏱️ Time and Space Complexity:

* **Time Complexity:** O(N + K log 26)

  * N = length of the string
  * 26 = number of lowercase letters (heap size is constant)
* **Space Complexity:** O(26) → constant space for character counts and heap

---

### ✅ Conclusion:

This is a classic **greedy + heap** problem where making the most optimal choice at each step leads to the globally optimal solution.
Perfect for interviews involving frequency counts, greedy strategies, and heaps.

---
