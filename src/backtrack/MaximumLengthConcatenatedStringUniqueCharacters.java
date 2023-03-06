package backtrack;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 05/03/2023
 */

public class MaximumLengthConcatenatedStringUniqueCharacters {

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("cha","r","act","ers");
        System.out.println(new MaximumLengthConcatenatedStringUniqueCharacters().maxLength(arr));
    }

    public int maxLength(List<String> arr) {
        this.arr = arr;
        back(0, new ArrayList<>(), 0);
        return ret;
    }

    List<String> arr;
    Set<Character> set = new HashSet<>();
    int ret = Integer.MIN_VALUE;
    void back(int i, List<String> temp, int t) {

        if (i == arr.size()) {
            ret = Math.max(ret, t);
            return;
        }

        String s = arr.get(i);
        if (isValid(s)) {
            temp.add(s);
            back(i+1, temp, t + s.length());
            for(char c: temp.remove(temp.size()-1).toCharArray() ) {
                set.remove(c);
            }
        }

        back(i+1, temp,t);
    }
    Set<Character> settemp = new HashSet<>();

    boolean isValid(String s) {
        settemp.clear();
        for (char c: s.toCharArray()) {
            if (settemp.contains(c) || set.contains(c)) return false;
            settemp.add(c);
        }
        set.addAll(settemp);
        return true;
    }
}
