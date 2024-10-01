import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxNum = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
            maxNum = Math.max(maxNum, map.get(book));
        }
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (String book : map.keySet()) {
            if (map.get(book) == maxNum) pq.add(book);
        }
        System.out.println(pq.poll());
    }
}