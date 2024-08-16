import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] score = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(info[j]);
            }
        }
        if (n == 1) {
            System.out.print(Math.max(score[0][2], Math.max(score[0][0], score[0][1])));
            System.out.print(" " + Math.min(score[0][2], Math.min(score[0][0], score[0][1])));
            return;
        }
        int[][][] dp = new int[n][3][2];
        dp[0][0][0] = score[0][0];
        dp[0][0][1] = score[0][0];
        dp[0][1][0] = score[0][1];
        dp[0][1][1] = score[0][1];
        dp[0][2][0] = score[0][2];
        dp[0][2][1] = score[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = score[i][0] + Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][0][1] = score[i][0] + Math.min(dp[i - 1][0][1], dp[i - 1][1][1]);
            dp[i][1][0] = score[i][1] + Math.max(dp[i - 1][2][0], Math.max(dp[i - 1][0][0], dp[i - 1][1][0]));
            dp[i][1][1] = score[i][1] + Math.min(dp[i - 1][2][1], Math.min(dp[i - 1][0][1], dp[i - 1][1][1]));
            dp[i][2][0] = score[i][2] + Math.max(dp[i - 1][1][0], dp[i - 1][2][0]);
            dp[i][2][1] = score[i][2] + Math.min(dp[i - 1][1][1], dp[i - 1][2][1]);
        }
        System.out.print(Math.max(dp[n - 1][2][0], Math.max(dp[n - 1][0][0], dp[n - 1][1][0])));
        System.out.print(" " + Math.min(dp[n - 1][2][1], Math.min(dp[n - 1][0][1], dp[n - 1][1][1])));
    }
}
