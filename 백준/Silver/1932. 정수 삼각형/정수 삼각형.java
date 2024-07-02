import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int rootNum = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(rootNum);
            return;
        }
        String[] secondRow = br.readLine().split(" ");
        int maxFirstNum = Integer.parseInt(secondRow[0]) + rootNum;
        int maxSecondNum = Integer.parseInt(secondRow[1]) + rootNum;
        if (n == 2) {
            System.out.println(Math.max(maxFirstNum, maxSecondNum));
            return;
        }
        List<Integer> dp = new LinkedList<>();
        dp.add(maxFirstNum);
        dp.add(maxSecondNum);
        for (int i = 2; i < n; i++) {
            int size = dp.size();
            String[] row = br.readLine().split(" ");
            dp.add(dp.get(0) + Integer.parseInt(row[0]));
            for (int idx = 1; idx < row.length - 1; idx++) {
                int left = dp.get(idx - 1);
                int right = dp.get(idx);
                dp.add(Integer.parseInt(row[idx]) + Math.max(left, right));
            }
            dp.add(dp.get(size - 1) + Integer.parseInt(row[row.length - 1]));
            dp.subList(0, size).clear();
        }
        System.out.println(Collections.max(dp));
    }
}
