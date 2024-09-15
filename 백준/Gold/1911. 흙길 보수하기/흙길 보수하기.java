import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        l = Integer.parseInt(strArr[1]);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            int start = Integer.parseInt(row[0]);
            int end = Integer.parseInt(row[1]);
            arr[i][0] = start;
            arr[i][1] = end;
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int answer = 0;
        int lastCovered = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (start > lastCovered) {
                lastCovered = start;  // 덮기 시작할 위치를 웅덩이 시작 지점으로
            }

            // 덮을 수 있을 때까지 널빤지를 사용
            while (lastCovered < end) {
                lastCovered += l;  // 널빤지로 덮고 마지막으로 덮은 위치 업데이트
                answer++;  // 널빤지 하나 사용
            }
        }
        System.out.println(answer);
    }
}
