import java.util.*;

class Solution {
    class Island implements Comparable<Island>{
        int num;
        int cost;

        public Island (int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo (Island o) {
            return this.cost - o.cost;
        }
    }

    public int solution(int n, int[][] costs) {
        List<List<Island>> map = new ArrayList<>();

        for (int i = 0; i < n; i++)
            map.add(new ArrayList<>());
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            map.get(from).add(new Island(to, cost));
            map.get(to).add(new Island(from, cost));
        }

        
        boolean[] visit = new boolean[n];
        PriorityQueue<Island> q = new PriorityQueue<>();
        q.add(new Island(0, 0));

        int result = 0;
        while(!q.isEmpty()) {
            Island cur = q.poll();

            if (visit[cur.num]) continue;
            visit[cur.num] = true;
            result += cur.cost;

            for (int i = 0; i < map.get(cur.num).size(); i++) {
                int next = map.get(cur.num).get(i).num;
                int cost = map.get(cur.num).get(i).cost;
                if (visit[next]) continue;
                q.add(new Island(next, cost));
            }
        }
        return result;
    }
}