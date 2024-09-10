import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] strArr = br.readLine().split(" ");
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr);
        long right = arr[arr.length - 1];
        long left = 0;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (parametricSearch(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean parametricSearch(long h) {
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > h) {
                total += h;
            } else total += arr[i];
        }
        return total <= m;
    }
}
