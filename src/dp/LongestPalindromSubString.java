package dp;

/**
 * @author Quang-Khai TRAN
 * @date 08/09/2022
 */

public class LongestPalindromSubString {

    public static void main(String ...args) {
        String s = "bananas";
        System.out.println(new LongestPalindromSubString().longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        char [] arr  = s.toCharArray();
        String res = "";
        for (int i = 0; i < arr.length; i+= next) {
            String tem = get(i,arr);
            if (tem.length() > res.length()) res = tem;
        }
        return res;
    }

    int next = 1;

    public String get(int i, char[] arr) {
        String current = arr[i] +"";
        return expand(current, i,i, 1, arr);
    }

    public String expand(String current, int i, int j, int k, char[] arr) {

        next = k;
        if (arr[i] == arr[j]) {
            if (j+1 < arr.length && arr[j] == arr[j+1]) {
                current += arr[j+1];
                return expand(current, i, j+1, k, arr);
            }
        }

        if (i-k< 0 || j+k >= arr.length) return current;

        if (arr[i-k] == arr[j+k]) {
            current = arr[i-k] + current + arr[i-k];
            return expand(current, i,j, k +1, arr);
        } else {
            return current;
        }
    }
}
