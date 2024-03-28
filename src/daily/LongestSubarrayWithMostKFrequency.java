package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Quang-Khai TRAN
 * @date 28/03/2024
 */

public class LongestSubarrayWithMostKFrequency {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3,2,1};
        System.out.println(maxSubLength(arr, 2));
    }

    public static int maxSubLength(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        int i = 0;
        int j = 0;
        Map<Integer, Integer> m = new HashMap<>();
        while (j < n) {
            int c = m.getOrDefault(arr[j], 0) + 1;
            if (c <= k) {
                m.put(arr[j], c);
                j++;
                continue;
            } j--;

            max = Math.max(max, j - i + 1);
            m.put(arr[i], m.get(arr[i]) -1);
            if (m.get(arr[i]) == 0)
                m.remove(arr[i]);
            i++;
            j++;
        }
        max = Math.max(max, j - i);
        return max;
    }
}
