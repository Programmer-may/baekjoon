import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] relation = br.readLine().split(" ");
            int node1 = Integer.parseInt(relation[0]);
            int node2 = Integer.parseInt(relation[1]);
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        int answer = 0;
        for (int nodeNum = 1; nodeNum <= n; nodeNum++) {
            if (!visited.contains(nodeNum)) {
                queue.add(nodeNum);
                visited.add(nodeNum);
                answer++;
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    List<Integer> next = graph.get(now);
                    for (int nextNode : next) {
                        if (!visited.contains(nextNode)) {
                            queue.add(nextNode);
                            visited.add(nextNode);
                        }
                    }
                }

            }
        }
        System.out.println(answer);
    }
}