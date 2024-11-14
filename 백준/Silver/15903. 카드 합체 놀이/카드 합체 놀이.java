import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(nums[i]));
        }
        while (m > 0) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
            pq.offer(sum);
            pq.offer(sum);
            m--;
        }
        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
