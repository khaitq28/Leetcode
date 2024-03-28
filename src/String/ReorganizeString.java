package String;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 28/09/2023
 */

public class ReorganizeString {

    public static void main(String[] args) {

        String s = "aaaa"; // v l v o  v    a b a b a c a c a
        ReorganizeString main = new ReorganizeString();
        System.out.println(main.reorganizeString(s));
    }

    Map<Character, Integer> map = new HashMap<>();
    public String reorganizeString(String s) {

        char[] arr = s.toCharArray();
        for (char c: arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Character> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) < map.get(o2) ? 1: -1);
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        int nextIns = 1;
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = map.get(c);
            if (sb.toString().length() == 0) {
                while (count > 0) {
                    sb.append(c); count --;
                }
                continue;
            }
            int i;
            for (i = nextIns; i <= sb.length() + 1 && count > 0; i +=2 ) {
                if (i >=  sb.length() +1) i = 1;
                sb.insert(i, c);
                count--;
            }
            nextIns = i;
            if (nextIns >=  sb.length()) nextIns = 1;
        }
        if (nextIns >= 1 && nextIns < sb.length() && sb.charAt(nextIns -1) == sb.charAt(nextIns)) return "";

        return sb.toString();
    }
}
