package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 */

public class IpAddress {

    char[] arr;
    List<String> ret = new ArrayList<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        arr= s.toCharArray();
        this.s = s;

        for (int width = 1; width <= 3; width ++) {
            backTrack(0, width, 3, new ArrayList<>());
        }

        return ret;
    }

    public static void main(String[] args) {
        String s = "2525511135";
        System.out.println(new IpAddress().restoreIpAddresses(s));
    }

    // 2525511135
    public void backTrack(int begin, int width, int dot, ArrayList<String> temp) {

        String sub = dot > 0 ?  this.s.substring(begin, Math.min(begin + width, s.length())): this.s.substring(begin);
        if (valid(sub)) {
            if (dot == 0) {
                String x = String.join(".", temp) + "." + sub;
                if (!ret.contains(x)) ret.add(x);
                return;
            }
            for (int i = 1; i <= 3; i ++) {
                if (begin + width < s.length()) {
                    temp.add(sub);
                    backTrack(begin +width, i, dot -1, temp);
                    temp.remove(temp.size() -1);
                }
            }
        }
    }

    private boolean valid(String s) {
        try{
            int number = Integer.parseInt(s);
            if (s.startsWith("0") && number == 0 && s.length() ==1) return true;
            return !s.startsWith("0") && number > 0 && number <= 255;
        }
        catch (NumberFormatException ex){
            return false;
        }
    }


}
