import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int K = Integer.parseInt(info[0]);
        int N = Integer.parseInt(info[1]);
        int[] lan = new int[K];
        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        long left = 1;
        long right = 0;
        for (int x : lan) right = Math.max(right, x);
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = 0;
            for (int i = 0; i < lan.length; i++) {
                tmp += (lan[i] / mid);
            }
            if (tmp >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}