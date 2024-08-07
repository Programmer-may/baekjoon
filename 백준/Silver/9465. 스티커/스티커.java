import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int width = Integer.parseInt(br.readLine());
            int[][] score = new int[2][width];
            for (int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < width; k++) {
                    score[j][k] = Integer.parseInt(input[k]);
                }
            }
            if (width == 1) {
                sb.append(Math.max(score[0][0], score[1][0])).append("\n");
                continue;
            }
            int[][] dp = new int[2][width];
            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];
            dp[0][1] = dp[1][0] + score[0][1];
            dp[1][1] = dp[0][0] + score[1][1];
            for (int j = 2; j < width; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + score[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + score[1][j];
            }
            sb.append(Math.max(dp[1][width - 1] , dp[0][width - 1])).append("\n");
        }
        System.out.print(sb);
    }
}