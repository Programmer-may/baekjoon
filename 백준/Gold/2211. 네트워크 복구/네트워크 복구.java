import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> graph = new ArrayList<>();
    static final int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int vertex = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);

        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int weight = Integer.parseInt(info[2]);
            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }
        int[] dist = new int[vertex + 1];
        int[] connection = new int[vertex + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        priorityQueue.add(new int[]{1, 0});
        dist[1] = 0;

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currVertex = current[0];
            int distance = current[1];
            if (dist[currVertex] < distance) continue;
            List<int[]> next = graph.get(currVertex);
            for (int[] neighbor : next) {
                int nextVertex = neighbor[0];
                int weight = neighbor[1];
                if (dist[nextVertex] > distance + weight) {
                    dist[nextVertex] = distance + weight;
                    priorityQueue.add(new int[]{nextVertex, dist[nextVertex]});
                    connection[nextVertex] = currVertex;
                }
            }
        }
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= vertex; i++) {
            if (connection[i] != 0) {
                k++;
                sb.append(i).append(" ").append((connection[i])).append("\n");
            }
        }
        sb.insert(0, k + "\n");
        System.out.println(sb.toString());
    }
}
