import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int s = Integer.parseInt(info[1]);
        int[] arr = new int[n];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int left = 0;
        int answer = Integer.MAX_VALUE;
        int tmp = 0;
        for (int right = 0; right < n; right++) {
            tmp += arr[right];
            while (tmp >= s) {
                answer = Math.min(answer, right - left + 1);
                tmp -= arr[left];
                left++;
            }
        }
        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}