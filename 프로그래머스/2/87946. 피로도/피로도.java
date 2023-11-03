import java.util.*;

class Solution {
    static int count = 0;
    static List<Integer> list = new ArrayList<>();

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0, visited, 0, dungeons.length, 0);
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    public void dfs(int[][] dungeons, int k, int i, boolean[] visited, int depth, int r, int count) {

        for (int j = 0; j < dungeons.length; j++) {
            if (!visited[j] && k >= dungeons[j][0]) {
                visited[j] = true;
                dfs(dungeons, k - dungeons[j][1], j, visited, depth + 1, dungeons.length, count + 1);
                visited[j] = false;
            }
        }
        list.add(count);
    }
}