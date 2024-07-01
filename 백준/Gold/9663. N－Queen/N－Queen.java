import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            //행에 일치하는게 있는지 판별
            if (arr[i] == arr[col]) {
                return false;
            }
            //대각선에 일치하는게 있는지 판별
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }

        }
        return true;
    }
}
