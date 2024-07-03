import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, String[]> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            graph.putIfAbsent(info[0], new String[2]);
            graph.get(info[0])[0] = info[1];
            graph.get(info[0])[1] = info[2];
        }
        String root = "A";
        preorderTraversal(root);
        inorderTraversal(root);
        postorderTraversal(root);

        System.out.println(sb.toString());
    }

    private static void preorderTraversal(String root) {
        Deque<String> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String curr = stack.pop();
            String[] child = graph.get(curr);
            sb.append(curr);
            if (!child[1].equals(".")) {
                stack.push(child[1]);
            }
            if (!child[0].equals(".")) {
                stack.push(child[0]);
            }
        }
        sb.append("\n");
    }

    private static void inorderTraversal(String root) {
        Deque<String> stack = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            String[] child = graph.get(curr);
            if (!child[0].equals(".") && !visited.contains(child[0])) {
                stack.push(child[0]);
            } else {
                stack.pop();
                visited.add(curr);
                sb.append(curr);
                if (!child[1].equals(".")) {
                    stack.push(child[1]);
                }
            }
        }
        sb.append("\n");
    }

    private static void postorderTraversal(String root) {
        Deque<String> stack = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            String[] child = graph.get(curr);
            if ((child[1].equals(".") || visited.contains(child[1])) && (child[0].equals(".") || visited.contains(child[0]))) {
                stack.pop();
                visited.add(curr);
                sb.append(curr);
            }
            if (!child[1].equals(".") && !visited.contains(child[1])) {
                stack.push(child[1]);
            }
            if (!child[0].equals(".") && !visited.contains(child[0])) {
                stack.push(child[0]);
            }

        }
        sb.append("\n");
    }
}
