import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            String[] item = br.readLine().split(" ");
            weights[i] = Integer.parseInt(item[0]);
            values[i] = Integer.parseInt(item[1]);
        }
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int weight = weights[i];
            int value = values[i];
            for (int w = k; w >= weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }
        System.out.println(dp[k]);
    }
}