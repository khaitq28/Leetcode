package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Quang-Khai TRAN
 */

public class LongestPalindrome {
    Map<String, Integer> m = new HashMap<>();
    int ret = 0;
    public int longestPalindrome(String[] words) {
        for (String s: words) {
            m.putIfAbsent(s, 0);
            m.put(s, m.get(s) + 1);
        }
        int mm = 0;
        String mid = null;
        for (Map.Entry<String,Integer> c :m.entrySet()) {
            String k = c.getKey();
            if (k.charAt(1) == k.charAt(0)) {
                if (c.getValue() > mm) {
                    mid = k;
                    mm = c.getValue();
                }
                continue;
            }
            int v = c.getValue();
            if (v == 0) continue;
            char[] xx = new char[] {k.charAt(1), k.charAt(0)};
            String op = new String(xx);
            Integer v2 = m.get(op);
            if (v2 == null || v2 ==0) continue;

            ret += 4 * Math.min(v,v2);
            c.setValue(0);
            m.put(op, 0);
        }
        ret += mm * 2;
        for (Map.Entry<String,Integer> c :m.entrySet()) {
            String k = c.getKey();
            int v = c.getValue();
            if (v > 0 && !k.equals(mid) &&  k.charAt(1) == k.charAt(0)) {
                if (mm %2 == 0) {
                    mm += v;
                    ret += v * 2;
                }
                else {
                    ret += 2 * (v%2 == 0? v : v -1);
                }
            }
        }
        return ret;
    }
}
