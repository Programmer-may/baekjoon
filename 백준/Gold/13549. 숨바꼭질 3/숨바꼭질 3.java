import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> isVisited = new HashSet<>();
        queue.add(new int[]{start, 0});
        isVisited.add(start);
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curPosition = now[0];
            int curTime = now[1];
            if (curPosition == end) {
                answer = Math.min(answer, curTime);
            }
            if (curPosition * 2 <= 100000 && !isVisited.contains(curPosition * 2)) {
                queue.add(new int[]{curPosition * 2, curTime});
                isVisited.add(curPosition * 2);
            }
            if (curPosition - 1 >= 0 && !isVisited.contains(curPosition - 1)) {
                queue.add(new int[]{curPosition - 1, curTime + 1});
                isVisited.add(curPosition - 1);
            }
            if (curPosition + 1 <= 100000 && !isVisited.contains(curPosition + 1)) {
                queue.add(new int[]{curPosition + 1, curTime + 1});
                isVisited.add(curPosition + 1);
            }
        }
        System.out.println(answer);
    }
}
