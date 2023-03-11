package backtrack;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 08/03/2023
 */

public class NQueen {
    public static void main(String[] args) {

        new NQueen().solveNQueens(5).forEach(e -> {
            e.forEach(System.out::println);
            System.out.println("---------------");
        });
    }

    Set<List<String>> ret = new HashSet<>();
    List<String> temp = new ArrayList<>();
    int [][]  danger ;
    private int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        danger = new int[n][n];
        back(0);
        return new ArrayList<>(ret);
    }

    void back(int line) {
        List<String> pos = getPosibilities(line);
        if(pos != null && pos.size() > 0) {

            if(line == this.n -1) {
                temp.add(pos.get(0));
                ret.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
                return;
            }

            for (String c: pos) {
                temp.add(c);
                updateDanger(c,true);
                back(line + 1);
                temp.remove(temp.size() -1);
                updateDanger(c, false);
            }
        }
    }

    void updateDanger(String s, boolean add) {

        int inc = add ? 1 : -1;
        int line = add ? temp.size() -1: temp.size();
        int y = 0;
        for (int k = 0; k < s.length(); k ++) {
            if (s.charAt(k) == 'Q') {
                y = k;
                break;
            }
        }

        int i = 1;
        int x = line;
        if (x >=0) danger[x][y] += inc;
        while (x > 0 ) {
            x --;
            danger[x][y] += inc;
            if (y - i >= 0) danger[x][y -i]+= inc;
            if (y + i < n) danger[x][y + i] += inc;
            i ++;
        }
        x = line;
        i = 1;
        while (x < n-1) {
            x ++;
            danger[x][y]+= inc;
            if (y - i >= 0) danger[x][y -i] += inc;
            if (y + i < n) danger[x][y + i] += inc;
            i ++;
        }

    }

    List<String> getPosibilities(int line) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (danger[line][i]<= 0) {
                char[] c = new char[n];
                Arrays.fill(c, '.');
                c[i] = 'Q';
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

}
