import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int furthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int length = Integer.parseInt(info[2]);
            tree.get(from).add(new int[]{to, length});
            tree.get(to).add(new int[]{from, length});
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        
        Arrays.fill(visited, false);
        maxDistance = 0;
        dfs(furthestNode, 0);
        
        System.out.println(maxDistance);
    }

    private static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            furthestNode = node;
        }

        for (int[] neighbor : tree.get(node)) {
            int nextNode = neighbor[0];
            int weight = neighbor[1];
            if (!visited[nextNode]) {
                dfs(nextNode, distance + weight);
            }
        }
    }
}
