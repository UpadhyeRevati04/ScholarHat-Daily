# Day 1 - Find the Number of Rotations in a Sorted Array

### 🔍 Problem Statement:
You are given a **sorted and rotated** array. Your task is to find the index of the smallest element, which is also the number of times the array has been rotated.

For example, for an array `[15, 18, 2, 3, 6, 12]`, the answer is `2` because the original sorted array `[2, 3, 6, 12, 15, 18]` was rotated **2 times**.

---

### 🧠 Intuition:
In a **rotated sorted array**, the smallest element marks the rotation point. Our task is to find that smallest element's index using a **modified binary search**.

---

### 🧮 Logic:
- If the array is already sorted (`arr[low] <= arr[high]`), then no rotation has happened.
- Use binary search:
  - Check if `arr[mid] > arr[mid + 1]` → return `mid + 1`
  - Check if `arr[mid - 1] > arr[mid]` → return `mid`
  - Else, recurse into the unsorted half

This ensures a time complexity of **O(log N)**.

---

### 👩‍💻 Code: `FindKRotation.java`

```java
import java.util.*;

class Solution {
    public int findKRotation(List<Integer> arr) {
        return countRotations(arr, 0, arr.size() - 1);
    }
    public int countRotations(List<Integer> arr, int low, int high) {
        if (high < low)
            return 0; 
        if (high == low)
            return low;  
        int mid = low + (high - low) / 2;
        if (mid < high && arr.get(mid + 1) < arr.get(mid))
            return mid + 1;
        if (mid > low && arr.get(mid) < arr.get(mid - 1))
            return mid;
        if (arr.get(high) > arr.get(mid))
            return countRotations(arr, low, mid - 1);
        return countRotations(arr, mid + 1, high);
    }
}
