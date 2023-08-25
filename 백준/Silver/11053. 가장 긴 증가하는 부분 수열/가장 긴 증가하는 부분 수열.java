import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int y = 0; y < i; y++) {
                if (A[y] < A[i]) {
                    dp[i] = Math.max(dp[y] + 1, dp[i]);
                }
            }
        }
        int answer = Arrays.stream(dp).max().getAsInt();
        System.out.println(answer);
    }
}