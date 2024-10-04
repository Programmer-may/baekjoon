import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> graph = new ArrayList<>();
    static long[] dist;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int totalNode = Integer.parseInt(info[0]);
        int totalEdge = Integer.parseInt(info[1]);
        for (int i = 0; i <= totalNode; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < totalEdge; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }
        String[] target = br.readLine().split(" ");
        int tar1 = Integer.parseInt(target[0]);
        int tar2 = Integer.parseInt(target[1]);
        dist = new long[totalNode + 1];
        long path1 = dijkstra(1, tar1) + dijkstra(tar1, tar2) + dijkstra(tar2, totalNode);
        long path2 = dijkstra(1, tar2) + dijkstra(tar2, tar1) + dijkstra(tar1, totalNode);
        if (path1 >= Integer.MAX_VALUE && path2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(path1, path2));
        }

    }

    private static long dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowDist = now[1];
            List<int[]> next = graph.get(nowNode);
            for (int[] neighbor : next) {
                int nextNode = neighbor[0];
                int weightFromNow = neighbor[1];
                if (dist[nextNode] > nowDist + weightFromNow) {
                    dist[nextNode] = nowDist + weightFromNow;
                    pq.add(new int[]{nextNode, (int) dist[nextNode]});
                }
            }
        }
        return dist[end];
    }
}
