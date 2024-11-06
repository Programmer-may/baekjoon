import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxCnt = 0;
        long targetNum = 0;
        for (long key : map.keySet()) {
            int cnt = map.get(key);
            if (maxCnt < cnt) {
                maxCnt = cnt;
                targetNum = key;
            } else if (maxCnt == cnt) {
                if (key < targetNum) {
                    targetNum = key;
                }
            }
        }
        System.out.println(targetNum);
    }
}
