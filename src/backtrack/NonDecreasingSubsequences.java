package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Quang-Khai TRAN
 * @date 04/03/2023
 */

public class NonDecreasingSubsequences {
    Set<List<Integer>> ret = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.arr = nums;
        back(0, new ArrayList<>());
        return new ArrayList<>(ret);
    }

    int[] arr;
    private void back(int begin, List<Integer> temp) {
        if (begin == arr.length) {
            if (temp.size()>=2) {
                ret.add(new ArrayList<>(temp));
            }
            return;
        }
        if(temp.isEmpty() || temp.get(temp.size()-1) <= arr[begin]) {
            temp.add(arr[begin]);
            back(begin+1, temp);
            temp.remove(temp.size()-1);
        }
        back(begin+1, temp);
    }

}
