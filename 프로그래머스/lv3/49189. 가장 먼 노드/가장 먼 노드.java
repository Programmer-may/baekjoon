import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : edge) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        int answer = 0;
        queue.add(1);
        visited.add(1);
        while (!queue.isEmpty()) {
            int currVertex = queue.poll();
            for (int i = 0; i < graph.get(currVertex).size(); i++) {
                int nextVertex = graph.get(currVertex).get(i);
                if (!visited.contains(nextVertex)) {
                    queue.add(nextVertex);
                    visited.add(nextVertex);
                    if (dist[nextVertex] > dist[currVertex] + 1) {
                        dist[nextVertex] = dist[currVertex] + 1;
                    }
                }
            }
        }
        int maxValue = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > maxValue) {
                maxValue = dist[i];
            }
        }
        for (int vertex : dist) {
            if (vertex == maxValue) {
                answer++;
            }
        }
        return answer;
    }
}