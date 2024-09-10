import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        arr = new int[n];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr[arr.length - 1] - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (parametricSearch(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean parametricSearch(int h) {
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > h) {
                total += arr[i] - h;
            }
        }
        return total >= m;
    }
}
