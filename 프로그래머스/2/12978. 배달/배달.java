import java.util.*;

class Solution {
    final int INF = 500001;
    
    public int solution(int N, int[][] road, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for (int[] info : road) {
            int from = info[0];
            int to = info[1];
            int weight = info[2];
            if (graph[from][to] != 0 && graph[from][to] <= weight) continue;
            graph[from][to] = weight;
            graph[to][from] = weight;
        }
        return dijkstra(graph, N, K);
    }
    private int dijkstra(int[][] graph, int N, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];
            if (dist[node] < distance) continue;
            int[] next = graph[node];
            for (int i = 1; i <= N; i++) {
                if (next[i] == 0) continue;
                if (dist[i] > distance + next[i]) {
                    dist[i] = distance + next[i];
                    pq.add(new int[]{i, dist[i]});
                }
            }
        }
        return countAnswer(dist, N, K);
    }
    
    private static int countAnswer(int[] dist, int N, int K) {
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
}