package backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Quang-Khai TRAN
 * @date 10/07/2022
 */

public class GenerateParathese {


    private final Set<String> all = new HashSet<>();

    public static void main(String[] args) {

        GenerateParathese generateParathese = new GenerateParathese();
        generateParathese.generate(new StringBuilder());
        System.out.println(generateParathese.all);
    }

    int c1; //number of (
    int c2; // number of )
    int n = 9; //number of pair


    /*
        logic: at position i, it could be '(' if number c1 < n, or it could be ')' if c2  < c1
     */
    private void generate(StringBuilder sb) {

        if (sb.length() == n * 2) {
            all.add(sb.toString());
            return;
        }
        if (c1 < n) {
            sb.append("(");
            c1++;
            generate(sb);
            c1--;
            sb.deleteCharAt(sb.length()-1);
        }

        if (c2 < c1) {
            sb.append(")");
            c2++;
            generate(sb);
            c2--;
            sb.deleteCharAt(sb.length()-1);
        }


    }


}
