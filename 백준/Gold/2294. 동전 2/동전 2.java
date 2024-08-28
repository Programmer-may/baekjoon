import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= k) dp[num] = 1;
            coins[i] = num;
        }
        for (int i = 1; i <= k; i++) {
            if(dp[i] == -1) {
                int value = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (i - coins[j] > 0 && dp[i - coins[j]] != -1) {
                        int tmp = dp[i - coins[j]] + 1;
                        value = Math.min(value, tmp);
                    }
                }
                if (value != Integer.MAX_VALUE) dp[i] = value;
            }
        }
        System.out.println(dp[k]);
    }
}