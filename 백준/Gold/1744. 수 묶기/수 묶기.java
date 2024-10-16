import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while (!priorityQueue.isEmpty()) {
            int num = priorityQueue.poll();
            if (num > 1) {
                if (!priorityQueue.isEmpty()) {
                    int next = priorityQueue.peek();
                    if (next > 1) {
                        answer += num * priorityQueue.poll();
                    } else {
                        answer += num;
                    }
                } else {
                    answer += num;
                }
            } else if (num == 1) {
                answer += num;
            } else if (num == 0) {
                if (!priorityQueue.isEmpty()) {
                    int next = priorityQueue.peek();
                    if (next < 0 && priorityQueue.size() % 2 != 0) {
                        answer += num * priorityQueue.poll();
                    } else {
                        answer += num;
                    }
                } else {
                    answer += num;
                }
            } else {
                if (!priorityQueue.isEmpty()) {
                    if (priorityQueue.size() % 2 != 0) {
                        int next = priorityQueue.poll();
                        answer += num * next;
                    } else {
                        answer += num;
                    }
                } else {
                    answer += num;
                }
            }
        }
        System.out.println(answer);
    }
}
