package math;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Quang-Khai TRAN
 * @date 12/09/2022
 */

public class Sum3 {


    public static void main (String ...args) {

        int [] arr = {};

        Sum3 s = new Sum3();
        s.threeSum(arr);

        System.out.println(s.res);

        System.out.println(s.twoSum(new int[]{-2, 0, 1, 2, 4, 5, 7}));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {

        List<Integer> arr = IntStream.of(nums).boxed().sorted().collect(Collectors.toList());

        for (int i = 0; i < arr.size(); i++) {
            sub(arr, i);
        }
        return res;
    }

    private void sub(List<Integer> list, int j) {
        int n = list.get(j);
        int sum = -n;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : list) {
            if (i != j) {
                if (map.get(i) != null) {
                    List<Integer> t = Arrays.asList(n,i,map.get(i));
                    res.add(t);
                } else {
                    map.put(sum -i, i);
                }
            }
        }
    }

    //-2, 0, 1, 2, 4, 5, 7
    //
    public List<List<Integer>> twoSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int c = 5;
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            if (set.contains(c - i)) {
                res.add(Arrays.asList(c-i, i));
            } else {
                set.add(i);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSumV2(int[] nums) {
        // -4 -2 -1 0 2 3 4 6

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        Set<String> s = new HashSet<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {

            int x = nums[i];
            if (s.contains(x) || x > 0) continue;

            int y;
            for (int j = i+1; j <n; j++) {
                y = nums[j];
                if (s.contains(x +","+ y)){
                    continue;
                }
                int z;
                for (int k = j+1; k <n; k++) {
                    z = nums[k];
                    if (s.contains(y +","+ z)){
                        break;
                    }
                    if ((x + y + z) == 0) {
                        res.add(Arrays.asList(x,y,z));
                        s.add(x + "," + y);
                        s.add(x + "," + z);
                        s.add(y + "," + z);
                    }
                }

            }

        }
        return res;
    }


}
