package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Quang-Khai TRAN
 * @date 14/08/2022
 */

public class MinCost {


    //[[0,0],[2,2],[3,10],[5,2],[7,0]]
    public static void main(String ...args )  {


        int[][] logs = {{0,0},{2,2},{3,10},{5,2},{7,0}};

        int d = new MinCost().minCostConnectPoints(logs);

        System.out.println(d);


    }
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        if (n == 1) return 0;
        boolean[] visit = new boolean[n];

        PriorityQueue<Edge> pq = new PriorityQueue<>(( (d1, d2) -> d1.d -d2.d));

        int d = 0;
        for (int i = 1; i < n; i++) {
            visit[i] = true;
            int[] p1 = points[0];
            int[] p2 = points[i];
            pq.add( new Edge(0, i, Math.abs(p1[0] -p2[0]) + Math.abs(p1[1] - p2[1])) );
        }


        int i = 1;
        while (!pq.isEmpty() && i < n) {

            Edge edge = pq.poll();
            if (!visit[edge.x] && !visit[edge.y]) continue;
            d += edge.d;
            int y = visit[edge.y] ? edge.y : edge.x;
            visit[y] = false;

            for (int k = 0; k < n; k++) {

                if (visit[k]) {

                    int[] p1 = points[k];
                    int[] p2 = points[y];

                    int cost = Math.abs(p1[0] -p2[0]) + Math.abs(p1[1] - p2[1]);
                    pq.add( y > k ? new Edge(k,y,cost) : new Edge(y,k,cost));
                }
            }
            i++;
        }

        return d;

    }

    public static class Edge {
        int x;
        int y;
        int d;

        public Edge(int x,int y, int d) {
            this.x = x;
            this.y =y;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    '}';
        }
    }


    private int getMinPoint(int[][] points, boolean[] visited, boolean[] visit) {
        int d = Integer.MAX_VALUE;
        int m = 0;

        for (int i = 0; i < points.length ; i++) {

            if (visited[i]) {

                for (int j = 0; j < points.length ; j++) {

                    if (visit[j]) {

                        int[] p1 = points[i];
                        int[] p2 = points[j];
                        int k =  Math.abs(p1[0] -p2[0]) + Math.abs(p1[1] - p2[1]);

                        System.out.println("i, j, d  = " + i + ", " + j + ", " + d);

                        if (d >= k) {
                            d = k;
                            m = j;
                        }
                    }

                }
            }
        }

        visited[m] = true;
        visit[m] = false;

        return d;
    }


}
