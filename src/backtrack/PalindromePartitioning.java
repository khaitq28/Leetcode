package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * 03/03/2023
 */

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "abbcdc";
        System.out.println(new PalindromePartitioning().partition(s));
    }

    List<List<String>> ret = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        int l = s.length();
        for (int i = 1; i <= l; i++ ) {
            backTrack(0, i, new ArrayList<>());
        }
        return ret;
    }

    private void backTrack(int begin, int w, List<String> temp) {

        String sub = s.substring(begin, begin +w);

        if (isValid(sub)) {

            if (begin +w == s.length()) {
                temp.add(sub);
                ret.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }

            for (int i =1; i <= s.length() - (begin + w); i++) {
                temp.add(sub);
                backTrack(begin + w, i, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isValid(String sub) {
        for (int i = 0 ; i <= sub.length()/2; i++) {
            if (sub.charAt(i) !=  sub.charAt(sub.length() -1 -i)) return false;
        }
        return true;
    }
}
