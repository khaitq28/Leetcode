package all;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author Quang-Khai TRAN
 * @date 03/11/2023
 */

public class SmallestNumberInfiniteSet {

    PriorityQueue<Integer> pq ;

    public SmallestNumberInfiniteSet() {
        pq = new PriorityQueue<>((a,b) -> a - b);
    }

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(3);
        pq.add(9);
        pq.add(1);
        pq.add(10);
        pq.add(13);
//        while (!pq.isEmpty()) System.out.println(pq.poll());
        for (int i: pq) System.out.println(i);

    }
    public int popSmallest() {

        if (pq.isEmpty() || pq.peek() > 1) {
            pq.add(1);
            System.out.println("popSmallest" + Arrays.toString(pq.toArray()));
            return 1;
        }
        Iterator<Integer> it = pq.iterator();
        int v;
        int cur = pq.peek() -1; boolean ok=  false;
        while(it.hasNext()) {
            cur ++;
            v = it.next();
            if (cur != v) {
                ok = true;
                break;
            }
        }
        pq.add(ok ? cur: cur+1);
        System.out.println("popSmallest" + Arrays.toString(pq.toArray()));
        return ok ? cur: cur+1;


    }

    public void addBack(int num) {
        System.out.println("addBack" + Arrays.toString(pq.toArray()));
        pq.remove((Integer)num);
        System.out.println("addBack after" + Arrays.toString(pq.toArray()));
    }
}
