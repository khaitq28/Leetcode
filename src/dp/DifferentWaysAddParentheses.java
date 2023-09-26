package dp;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 23/09/2023
 */

public class DifferentWaysAddParentheses {

    char[] arr ;
    private List<Integer>[][] memo;
    public List<Integer> diffWaysToCompute(String s) {
        arr = s.toCharArray();
        memo = new ArrayList[arr.length][arr.length];

        List<Integer> list = test(0, arr.length-1);
        return new ArrayList<>(list);
    }
    boolean isOperator(char c){
        return c == '+' || c== '-' || c== '*';
    }

    public static void main(String[] args) {
        String s = "11";
        val main = new DifferentWaysAddParentheses();
        System.out.println(main.diffWaysToCompute(s));
    }
    List<Integer> test(int s, int e){
        if (s ==e) return List.of(Integer.valueOf(String.valueOf(arr[s])));
        List<Integer> tem= new ArrayList<>();
        boolean containsOperator = false;
        if (memo[s][e] != null) return memo[s][e];
        for(int i = s; i<=e; i ++) {
            char c= arr[i];
            if (isOperator(arr[i])) {
                containsOperator = true;
                List<Integer> v = test(s,i-1);
                List<Integer> t = test(i+1, e);
                for(int a: v){
                    for(int b:t) {
                        int x = c=='+'? a+b: c=='-'? a-b: a*b;
                        tem.add(x);
                    }
                }
            }
        }
        if (!containsOperator) {
            tem.add(Integer.valueOf(new String(Arrays.copyOfRange(arr,s,e+1))));
        }
        memo[s][e] = tem;
        return tem;
    }
}
