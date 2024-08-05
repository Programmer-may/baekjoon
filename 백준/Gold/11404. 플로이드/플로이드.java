import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCity = Integer.parseInt(br.readLine());
        int totalEdge = Integer.parseInt(br.readLine());
        int[][] dist = new int[totalCity + 1][totalCity + 1];
        for (int i = 1; i <= totalCity; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < totalEdge; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            dist[from][to] = Math.min(dist[from][to], cost);
        }
        for (int k = 1; k <= totalCity; k++) {
            for (int i = 1; i <= totalCity; i++) {
                for (int j = 1; j <= totalCity; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= totalCity; i++) {
            for (int j = 1; j <= totalCity; j++) {
                if (dist[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
