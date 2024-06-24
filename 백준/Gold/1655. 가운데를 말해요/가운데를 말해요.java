import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.size() <= minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int tempMax = maxHeap.poll();
                int tempMin = minHeap.poll();
                maxHeap.offer(tempMin);
                minHeap.offer(tempMax);
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb.toString());
    }
}