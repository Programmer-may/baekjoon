import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Set<Integer> isVisited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        isVisited.add(n);
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if (now == 1) {
                    System.out.println(answer);
                    return;
                }
                if (now % 3 == 0) {
                    int next = now / 3;
                    if (!isVisited.contains(next) && next > 0) {
                        queue.add(next);
                        isVisited.add(next);
                    }
                }
                if (now % 2 == 0) {
                    int next = now / 2;
                    if (!isVisited.contains(next) && next > 0) {
                        queue.add(next);
                        isVisited.add(next);
                    }
                }
                queue.add(now - 1);
                isVisited.add(now - 1);
            }
            answer++;
        }
    }
}