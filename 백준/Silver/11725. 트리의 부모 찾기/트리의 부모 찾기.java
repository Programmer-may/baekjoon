import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        int[] answer = new int[n + 1];
        queue.add(1);
        isVisited[1] = true;
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            List<Integer> children = graph.get(parent);
            for (int child : children) {
                if (!isVisited[child]) {
                    answer[child] = parent;
                    queue.add(child);
                    isVisited[child] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }
}
