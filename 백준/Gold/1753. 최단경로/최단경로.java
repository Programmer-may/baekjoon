import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(br.readLine());
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            String[] readArr = br.readLine().split(" ");
            graph.get(Integer.parseInt(readArr[0])).add(new Node(Integer.parseInt(readArr[1]), Integer.parseInt(readArr[2])));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        pq.add(new Node(startVertex, 0));
        dist[startVertex] = 0;
        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int currVertex = currNode.end;
            if (!check[currVertex]) {
                check[currVertex] = true;
                for (Node node : graph.get(currVertex)) {
                    if (dist[node.end] > dist[currVertex] + node.weight) {
                        dist[node.end] = dist[currVertex] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            int distanceFromStart = dist[i];
            if (distanceFromStart == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(distanceFromStart + "\n");
        }
        System.out.print(sb);
    }
}