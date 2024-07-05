import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<int[]>> toGo = new ArrayList<>();
    static List<List<int[]>> comeBack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String[] info = br.readLine().split(" ");
        int totalTowns = Integer.parseInt(info[0]);
        int totalRoads = Integer.parseInt(info[1]);
        int target = Integer.parseInt(info[2]);
        for (int i = 0; i <= totalTowns; i++) {
            toGo.add(new ArrayList<>());
            comeBack.add(new ArrayList<>());
        }
        for (int i = 0; i < totalRoads; i++) {
            String[] direction = br.readLine().split(" ");
            int start = Integer.parseInt(direction[0]);
            int end = Integer.parseInt(direction[1]);
            int edge = Integer.parseInt(direction[2]);
            toGo.get(start).add(new int[]{end, edge});
            comeBack.get(end).add(new int[]{start, edge});
        }
        int[] dist = new int[totalTowns + 1];
        int[] reverseDist = new int[totalTowns + 1];
        dijkstra(toGo, dist, target, totalTowns);
        dijkstra(comeBack, reverseDist, target, totalTowns);
        int max = 0;
        for (int i = 1; i <= totalTowns; i++) {
            max = Math.max(max, dist[i] + reverseDist[i]);
        }
        System.out.println(max);
    }

    static void dijkstra(List<List<int[]>> graph, int[] dist, int start, int totalTowns) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            for (int[] next : graph.get(currNode)) {
                int nextNode = next[0];
                int weight = next[1];
                if (dist[nextNode] > dist[currNode] + weight) {
                    dist[nextNode] = dist[currNode] + weight;
                    pq.add(next);
                }
            }
        }
    }
}