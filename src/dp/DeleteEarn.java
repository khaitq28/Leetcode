package dp;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 25/09/2022
 */

public class DeleteEarn {

    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new DeleteEarn().deleteAndEarn(new int[]{3, 4, 2}));
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            if  (m.get(i) == null) {
                list.add(i);
                m.put(i, 1);
            }
            else m.put(i, m.get(i) + 1);
        }

        return dp(m, list.get(list.size() -1));
    }
    Map<Integer,Integer> values= new HashMap<>();

    private int dp(Map<Integer, Integer> m, int i) {

        Integer val = m.get(i);

        if (i == list.get(0)) return val * i;
        if (i < list.get(0)) return 0;

        if ( val == null) return dp(m, i -1);

        if (values.get(i) ==  null) {

            int include = val * i + dp(m, i-2);
            int exclude = dp(m, i-1);
            values.put(i, Math.max(include, exclude));
        }
        return values.get(i);

    }
}
