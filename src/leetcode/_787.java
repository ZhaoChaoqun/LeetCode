package leetcode;

public class _787 {

    public static void main(String[] args) {
        _787 test = new _787();
//        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
//        System.out.println(test.findCheapestPrice(3, flights, 0, 2, 1));
//        System.out.println(test.findCheapestPrice(3, flights, 0, 2, 0));
//        System.out.println(test.findCheapestPrice(5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1));
        System.out.println(test.findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] path = new int[n][n];
//        dist表示到达第i个点，j次中转下的最短距离
        int[][] dist = new int[n][K+1];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j <= K; j++)
            dist[i][j] = -1;
        }
//        for (int i = 0; i < flights.length; i++) {
//            if (flights[i][0] == src)
//                dist[flights[i][1]][0] = flights[i][2];
//        }
//        dist[src][0] = 0;
//        int[] pos = new int[n];
//        for (int k = 0; k <= K; k++) {
//            for(int j = 0; j < n; j++) {
//                if (dist[j][k] != -1) {
//                    int u = j;
//                    for (int i = 0; i < flights.length; i++) {
//                        if (flights[i][0] == u) {
//                            int w = flights[i][1];
//                            if (dist[w] == -1 || dist[w] > dist[u] + flights[i][2]) {
//                                dist[w] = dist[u] + flights[i][2];
//                                pos[w] = pos[u] + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= K; i++){
            if(dist[dst][i] != -1 && dist[dst][i] < min) {
                min = dist[dst][i];
            }
        }
        return min;
    }

}
