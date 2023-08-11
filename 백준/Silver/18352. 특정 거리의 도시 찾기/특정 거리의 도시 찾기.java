import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cityNum = Integer.parseInt(st.nextToken());
        int distanceNum = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int src = Integer.parseInt(st.nextToken());

        List<List<Integer>> connection = new ArrayList<>();
        for (int i = 0; i <= cityNum; i++) {
            connection.add(new ArrayList<>());
        }

        for (int i = 0; i < distanceNum; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int pre_city = Integer.parseInt(st2.nextToken());
            int post_city = Integer.parseInt(st2.nextToken());
            connection.get(pre_city).add(post_city);

        }

        int[] dist = new int[cityNum + 1];
        for (int i = 0; i <= cityNum; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int city = info[0];
            int distance = info[1];
            if (dist[city] < distance) {
                continue;
            }
            for (int i = 0; i < connection.get(city).size(); i++) {
                if (dist[connection.get(city).get(i)] > dist[city] + 1) {
                    dist[connection.get(city).get(i)] = dist[city] + 1;
                    pq.add(new int[]{connection.get(city).get(i), dist[connection.get(city).get(i)]});
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= cityNum; i++) {
            if (dist[i] == goal) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println(-1);
        }
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}