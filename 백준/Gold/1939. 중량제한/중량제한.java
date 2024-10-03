import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        // 그래프 초기화
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 다리 정보 입력
        int minWeight = 1;  // 최소 중량
        int maxWeight = 0;  // 최대 중량
        for (int i = 0; i < m; i++) {
            String[] relation = br.readLine().split(" ");
            int node1 = Integer.parseInt(relation[0]);
            int node2 = Integer.parseInt(relation[1]);
            int weight = Integer.parseInt(relation[2]);
            graph.get(node1).add(new int[]{node2, weight});
            graph.get(node2).add(new int[]{node1, weight});
            maxWeight = Math.max(maxWeight, weight);  // 최대 중량 업데이트
        }

        String[] target = br.readLine().split(" ");
        int start = Integer.parseInt(target[0]);
        int end = Integer.parseInt(target[1]);

        // 이분 탐색을 통한 최대 중량 탐색
        int answer = minWeight;
        while (minWeight <= maxWeight) {
            int midWeight = (minWeight + maxWeight) / 2;
            if (canMove(start, end, midWeight, n, graph)) {
                answer = midWeight;
                minWeight = midWeight + 1;  // 더 큰 중량을 탐색
            } else {
                maxWeight = midWeight - 1;  // 더 작은 중량을 탐색
            }
        }
        System.out.println(answer);
    }

    // BFS로 현재 중량으로 목적지까지 갈 수 있는지 확인
    private static boolean canMove(int start, int end, int limit, int n, List<List<int[]>> graph) {
        boolean[] isVisited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == end) return true;

            for (int[] next : graph.get(curr)) {
                int nextNode = next[0];
                int weight = next[1];

                if (!isVisited[nextNode] && weight >= limit) {  // 중량 조건을 만족해야 함
                    queue.add(nextNode);
                    isVisited[nextNode] = true;
                }
            }
        }
        return false;
    }
}