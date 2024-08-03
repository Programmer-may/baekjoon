import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(N);
        visited[N] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == K) {
                    System.out.println(time);
                    return;
                }
                
                if (current - 1 >= 0 && !visited[current - 1]) {
                    queue.add(current - 1);
                    visited[current - 1] = true;
                }

                if (current + 1 <= 100000 && !visited[current + 1]) {
                    queue.add(current + 1);
                    visited[current + 1] = true;
                }

                if (current * 2 <= 100000 && !visited[current * 2]) {
                    queue.add(current * 2);
                    visited[current * 2] = true;
                }
            }
            time++;
        }
    }
}
