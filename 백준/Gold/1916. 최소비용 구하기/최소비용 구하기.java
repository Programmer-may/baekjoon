import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> tree;
    static boolean[] visited;
    static int[] dist;
    static int n;
    static final int INF = 100000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        int totalEdge = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalEdge; i++) {
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int fee = Integer.parseInt(info[2]);
            tree.get(from).add(new int[]{to, fee});
        }
        String[] info = br.readLine().split(" ");
        int start = Integer.parseInt(info[0]);
        int target = Integer.parseInt(info[1]);
        System.out.println(dijkstra(start, target));
    }
    private static int dijkstra(int start, int target) {
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                List<int[]> neighbor = tree.get(currentNode);
                for (int[] next : neighbor) {
                    int nextNode = next[0];
                    int weight = next[1];
                    if (!visited[nextNode]) {
                        if (dist[nextNode] > dist[currentNode] + weight) {
                            dist[nextNode] = dist[currentNode] + weight;
                            pq.add(new int[] {nextNode, dist[nextNode]});
                        }
                    }
                }
            }
        }
        return dist[target];
    }
}