import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int start = 1;
        int end = houses[N - 1] - houses[0];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (canInstall(houses, N, C, mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canInstall(int[] houses, int N, int C, int distance) {
        int count = 1;
        int lastInstalled = houses[0];

        for (int i = 1; i < N; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i];
            }
        }

        return count >= C;
    }
}
