package dp;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 15/10/2022
 */

public class WordBreak {


    /*
        Input: s = "leetcode", wordDict = ["leet","code"]
        Output: true

        Input: s = "apple pen apple", wordDict = ["apple","pen"]
        Output: true

        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        Output: false

       s = "aba"   dict = a b
     */

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet"); dict.add("code");

        System.out.println(new WordBreak().wordBreak(s, dict));
    }

    List<String> wordDict;
    String s;
    Map<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.head = new int[s.length() + 1];
        this.wordDict = wordDict;
        Arrays.fill(head, -1);
        return br2(0);
    }

    int[] head;
    private boolean br2(int k) {
        if(head[k] == -1) {
            String text = s.substring(k, s.length());
            boolean res = false;
            if(text.length() == 1) {
                return wordDict.contains(text);
            }
            for (int i = 0; i < text.length(); i++) {
                String first = text.substring(0, i + 1);
                if (!wordDict.contains(first)) continue;
                boolean item = br2(k +i + 1);
                res = res || item || wordDict.contains(text);
            }
            head[k] = res ? 1: 0;
        }
        return head[k] == 1;
    }




    private boolean br(String text) {
        if(memo.get(text) == null) {
            char[] arr = text.toCharArray();
            boolean res = false;
            if(arr.length == 1) {
                return wordDict.contains(text);
            }
            for (int i = 0; i < arr.length; i++) {
                String first = text.substring(0, i + 1);
                if (!wordDict.contains(first)) continue;

                boolean item = br(text.substring(i +1, arr.length));
                res = res || item || wordDict.contains(text);
            }
            memo.put(text, res);
        }
        return memo.get(text);
    }
}
