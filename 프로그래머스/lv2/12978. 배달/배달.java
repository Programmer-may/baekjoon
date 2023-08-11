import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int townNum = N;
        int goalWeight = K;
        int[][] graph = new int[townNum + 1][townNum + 1];


        for (int i = 0; i < road.length; i++) {
            if (graph[road[i][0]][road[i][1]] != 0 && graph[road[i][0]][road[i][1]] < road[i][2]) {
                continue;
            }
            graph[road[i][0]][road[i][1]] = road[i][2];
            graph[road[i][1]][road[i][0]] = road[i][2];
        }

        int[] dist = new int[townNum + 1];
        for (int i = 0; i <= townNum; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int city = info[0];
            int distance = info[1];
            if (dist[city] < distance) {
                continue;
            }
            for (int i = 1; i <= townNum; i++) {
                if (graph[city][i] > 0) {
                    if (dist[i] > dist[city] + graph[city][i]) {
                        dist[i] = dist[city] + graph[city][i];
                        pq.add(new int[]{i, dist[i]});
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= townNum; i++) {
            if (dist[i] <= goalWeight) {
                answer++;
            }
        }
        return answer;
    }
}