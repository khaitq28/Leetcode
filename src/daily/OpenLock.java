package daily;

import java.util.*;

public class OpenLock {

    public static void main(String[] args) {

        String[] deads = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "2345";

        OpenLock openLock = new OpenLock();
        System.out.println(openLock.openLock(deads, target));
    }

    public int openLock(String[] deads, String t) {
        Set<String> set = new HashSet<>(Arrays.asList(deads));
        Map<String, Integer> p = new HashMap<>();
        p.put("0000", 0);
        if (set.contains("0000")) return -1;
        Queue<String> st = new ArrayDeque<>(); st.add("0000");
        Map<Character, Character> next = Map.of('0','1','1','2','2','3','3','4','4','5','5','6','6','7','7','8','8','9','9','0');
        Map<Character, Character> pre = Map.of('0','9','1','0','2','1','3','2','4','3','5','4','6','5','7','6','8','7','9','8');

        while (!st.isEmpty()) {
            String k = st.poll();
            StringBuilder sb = new StringBuilder(k);
            for (int j = 0; j < 4; j++) {
                char c = sb.charAt(j);
                sb.setCharAt(j, next.get(c));
                String s1 = sb.toString();
                if (!set.contains(s1)) {
                    if (p.get(s1) == null || p.get(s1) > p.get(k) +1) {
                        p.put(s1, p.get(k) +1);
                        st.add(s1);
                    }
                }
                sb.setCharAt(j, pre.get(c));
                String s2 = sb.toString();
                if (!set.contains(s2)) {
                    if (p.get(s2) == null || p.get(s2) > p.get(k) +1) {
                        p.put(s2, p.get(k) +1);
                        st.add(s2);
                    }
                }
                sb.setCharAt(j, c);
                if (p.get(t) != null) return p.get(t);
            }
        }
        Integer x =  p.get(t) ;
        return x == null ? -1: x;

    }
}
