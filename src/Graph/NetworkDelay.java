package Graph;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 21/08/2022
 */

public class NetworkDelay {

    boolean[] marked;
    int[] distanceTo;
    int[] previousTo;

    Map<Integer, List<MinCost.Edge>> map = new HashMap<>();


    //        Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    public static void main(String ...args)  {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}, {2,4,3}, {3,5,5}, {4,5,2}};
        NetworkDelay delay = new NetworkDelay();

        int t = delay.networkDelayTime(times, 5,3);

        System.out.println(t);

        System.out.println(delay.pathTo(3,5));
    }

    public Queue<Integer> pathTo(int s, int m) {
        Queue<Integer> st = new ArrayDeque<>();
        while (m != previousTo[m] && m != s) {
            st.add(m);
            m = previousTo[m];
        }
        st.add(s);
        return st;
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        initGraph(times);
        int sum = 0;

        marked  = new boolean[n+1];
        distanceTo = new int[n+1];
        previousTo = new int[n+1];

        marked[k] = true;
        int m = 0;
        for (int i = 0; i <= n; i++) {
            distanceTo[i] = Integer.MAX_VALUE;
        }
        distanceTo[k] = 0;

        PriorityQueue<MinCost.Edge> queue = new PriorityQueue<>((i,j) -> i.d > j.d ? 1: -1);
        queue.add(new MinCost.Edge(k,k,0));
        while(!queue.isEmpty()) {
            MinCost.Edge node = queue.poll();
            int temp = node.y;
            List<MinCost.Edge> nei = map.get(temp);
            marked[temp] = true;
            m++;
            if ( nei != null ) {
                for (MinCost.Edge edge: nei) {
                    if (distanceTo[edge.y] > edge.d + distanceTo[edge.x]) {
                        distanceTo[edge.y] = edge.d + distanceTo[edge.x];
                        previousTo[edge.y] = edge.x;
                        queue.add(edge);
                    }
                }
            }
        }

        if (m < n) return -1;

        for (int d = 1; d < distanceTo.length; d ++) {
            if (sum < distanceTo[d]) sum = distanceTo[d];
        }

        return sum;
    }

    private void initGraph(int[][] times) {
        for (int[] edge : times) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(new MinCost.Edge(edge[0], edge[1], edge[2]));
        }
    }

}
