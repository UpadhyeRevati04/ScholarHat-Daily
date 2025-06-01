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
            return (mid + 1);

        if (mid > low && arr.get(mid) < arr.get(mid - 1))
            return mid;

        if (arr.get(high) > arr.get(mid))
            return countRotations(arr, low, mid - 1);

        return countRotations(arr, mid + 1, high);
    }
}

            