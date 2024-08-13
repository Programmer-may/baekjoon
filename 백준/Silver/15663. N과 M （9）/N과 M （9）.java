import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] numbers;
    static boolean[] isVisited;
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        numbers = new int[N];
        isVisited = new boolean[N];
        output = new int[M];
        
        String[] numStr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numStr[i]);
        }
        
        Arrays.sort(numbers);
        
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(' ');
            }
            System.out.println(sb.toString().trim());
            return;
        }

        int lastUsed = 0;
        for (int i = 0; i < N; i++) {
            if (!isVisited[i] && numbers[i] != lastUsed) {
                isVisited[i] = true;
                output[depth] = numbers[i];
                lastUsed = numbers[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
