package Graph;

import com.sun.deploy.cache.BaseLocalApplicationProperties;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 12/10/2022
 */

public class EvaluateDivision {

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c") );
        double[] values = {2.0,3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a","c"), Arrays.asList("b","a"), Arrays.asList("a","e") , Arrays.asList("a","a") , Arrays.asList("x","x") );

        for (double v : new EvaluateDivision().calcEquation(equations, values, queries)) {
            System.out.println(v);
        }
    }
    /*
    [["a","b"],["b","c"]]
[2.0,3.0]
[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     */

    Map<String, List<EQ>> map = new HashMap<>();
    boolean found = false;
    String target;
    Map<String,EQ> path = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] cal = new double[queries.size()];
        int index = 0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> xy = equations.get(i);
            map.putIfAbsent(xy.get(0), new ArrayList<>());
            map.get(xy.get(0)).add(new EQ(xy, values[i]));
            map.put(xy.get(0), map.get(xy.get(0)));

            map.putIfAbsent(xy.get(1), new ArrayList<>());
            map.get(xy.get(1)).add(new EQ(Arrays.asList(xy.get(1), xy.get(0)), 1/values[i]));
            map.put(xy.get(1), map.get(xy.get(1)));
        }
        for (List<String> query : queries) {
            double res = calcul(query);
            cal[index++] = res;
            found = false;
            set.clear();
        }
        return cal;
    }



    private double calcul(List<String> query) {
        String from = query.get(0);
        target = query.get(1);
        ds(from);
        if (found) {
            EQ eq = path.get(target);
            double res = eq.val;
            while (!eq.node.get(0).equals(from)) {
                eq = path.get(eq.node.get(0));
                res *= eq.val;
            }
            return res;
        }
        return -1;
    }
    Set<EQ> set = new HashSet<>();
    private void ds(String from) {
        if (map.get(from) == null) return;
        for (EQ eq : map.get(from)) {
            if (!set.contains(eq)) {
                set.add(eq);
                path.put(eq.node.get(1), eq);
                if (eq.node.get(1).equals(target)) {
                    found = true; return;
                }
                ds(eq.node.get(1));
            }
        }
    }


    public static class EQ {
        public List<String> node;
        public double val;
        public EQ(List<String> node, double val) {
            this.node = node;
            this.val = val;
        }
    }



}
