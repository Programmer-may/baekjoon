import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] num;
    static boolean[] isVisited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        num = new int[m];
        isVisited = new boolean[n + 1];
        dfs(1, 0);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(num[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
            sb.setLength(0);
            return;
        }
        for (int i = start; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                num[depth] = i;
                dfs(i + 1, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}