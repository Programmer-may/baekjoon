import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;
        int maxNUM = input / 5;
        for (int i = maxNUM; i >= 0; i--) {
            int tmp = 0;
            if ((input - i * 5) % 3 == 0) {
                tmp = i + (input - i * 5) / 3;
                if (tmp < answer) {
                    answer = tmp;
                }
            }
        }
        if (answer != Integer.MAX_VALUE) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}