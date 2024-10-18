import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> tree;
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int fee = Integer.parseInt(info[2]);
            tree.get(from).add(new int[]{to, fee});
            tree.get(to).add(new int[]{from, fee});
        }
        System.out.println(prim());
    }
    private static int prim() {
        visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});
        int mstWeight = 0;  // 최소 신장 트리 가중치의 합
        int edgeCount = 0;  // 선택한 간선의 수
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int weight = current[1];

            if (visited[currentNode]) continue;
            visited[currentNode] = true;
            mstWeight += weight;
            edgeCount++;

            if (edgeCount == n) {
                break;
            }
            for (int[] next : tree.get(currentNode)) {
                if (!visited[next[0]]) {
                    pq.add(next);
                }
            }
        }
        return mstWeight;
    }
}

