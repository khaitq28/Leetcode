package daily;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 25/07/2024
 */

public class MaxScoreRemoveSubString {

    public static void main(String[] args) {


    }

    public int maximumGain(String s, int x, int y) {
        int res = 0;
        char[] arr = s.toCharArray();

        char a = x > y ? 'a' : 'b';
        char b = x > y ? 'b' : 'a';

        // remove ab get more
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(char c: arr) {
            s1.push(c);
        }
        // c d b c  a  b
        while (!s1.isEmpty()) {
            char c = s1.pop();
             if(c== a && !s2.isEmpty() && s2.peek() == b) {
                 s2.pop();
                 res += Math.max(x, y);
             } else {
                 s2.push(c);
             }
        }
        while (!s2.isEmpty()) {
            char c = s2.pop();
            if (c == b && !s1.isEmpty() && s1.peek() == a) {
                s1.pop();
                res += Math.min(x, y);
            } else {
                s1.push(c);
            }
        }

        return res;
    }

    public int[] fre(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int n: nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int[] res = new int[nums.length];
        List<Integer> set = new ArrayList<>(m.keySet());
        Collections.sort(set, (a, b) -> {
            if (m.get(a) == m.get(b)) return a > b ? -1:1;
            return m.get(a) > m.get(b) ? 1:-1;
        });
        int i = 0;
        while (i< res.length) {
            for(int n: set) {
                int v = m.get(n);
                while(v > 0) {
                    res[i++] = n;
                    v--;
                }
            }
        }
        return res;
    }

    //a v t b b a q a o b p a a b b p

    //  a a b b p

}
