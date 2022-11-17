package backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Quang-Khai TRAN
 * @date 10/07/2022
 */

public class GenerateParathese {


    private final Set<String> all = new HashSet<>();
    private List<String> param;

    public void generateCombination() {
        init(0);
        System.out.println("all");
        System.out.println(all);
    }

    private void init(int i) {
        boolean[] marked = new boolean[this.param.size()];
        marked[i] = true;
        List<String> arr = new ArrayList<>();
        String current = this.param.get(i);
        arr.add(current);
        backtrack(marked, arr);
    }

    private void backtrack(boolean[] marked, List<String> arr) {
        if(arr.size() == param.size() && arr.get(arr.size()-1).equals(")")) {
            System.out.println(arr);
            all.add(arr.stream().reduce("", (s,v) -> s+v));
            return;
        }
        for (int i = 0; i < param.size(); i++) {
            if(!marked[i]) {
                String tem = param.get(i);
                marked[i] = true;
                arr.add(tem);
                backtrack(marked,arr);
                arr.remove(arr.size()-1);
                marked[i] = false;
            }
        }
    }

    public static void main(String ...art) {
        List<String> param = Arrays.asList("(",")","(",")","(",")");
        GenerateParathese main = new GenerateParathese();
        main.param = param;

        /*
        main.generateCombination();
        */
    }

    public void generate2() {
        int n = 3;

        boolean[] marked = new boolean[n];
        marked[0] = true;
        List<String> arr = new ArrayList<>();
        arr.add("()");
//        backtrack2(arr, marked);
    }



}
