import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);

        sequence = new int[m];
        dfs(0);
        System.out.print(sb.toString());
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int num : sequence) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            sequence[depth] = i;
            dfs(depth + 1);
        }
    }
}
