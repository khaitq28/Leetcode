package backtrack;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Classical {


    public static void main(String ...args) {

        // A , B , C   =>  ABC, CBA,  // ACB,CAB,BAC,BCA

        List<String> l = new ArrayList<String>(); l.add("A"); l.add("B"); l.add("C");
        List<Boolean> b = new ArrayList<>();  l.forEach(e -> {
            b.add(false);
        });
        b.set(0,true);
        int r = back(l, 0, 0, 1, b);


    }

    /*  A B C
                   A           B               C
                 B   C       A  C            A   B
      */
    private static int back(List<String> arr, int index, int count, int size, List<Boolean> b) {

        for (int i = 0; i < arr.size(); i ++) {

                if( isOk(arr, i, index, b)) {
                    b.set(i,true);
                    size ++;
                    if (size == arr.size()) {
                        count ++;
                    } else  {
                        count = back(arr, ++index, count, size, b);
                    }

                }


        }

        return 0;
    }

    private static boolean isOk(List<String> arr, int i, int index,  List<Boolean> b) {
        String s = arr.get(i) + arr.get(index);
        return !b.get(i) && i != index &&  !s.equals("AC") && ! s.equals("CA");
    }


}
