import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);
        int[] arr = new int[n];
        String[] row = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(row[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < n; right++) {
            int currentNum = arr[right];
            map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);

            // 동일한 숫자가 K개를 초과하면 left 포인터를 이동
            while (map.get(currentNum) > k) {
                int leftNum = arr[left];
                map.put(leftNum, map.get(leftNum) - 1);
                left++;
            }

            // 최장 연속 부분 수열 길이 갱신
            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }
}