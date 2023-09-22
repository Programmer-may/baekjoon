import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int rLimit = maps.length;
        int cLimit = maps[0].length;
        queue.add(new int[]{0, 0});
        int lev = 1;
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            lev++;
            int leng = queue.size();
            for (int i = 0; i < leng; i++) {
                int[] curr = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = curr[0] + dr[k];
                    int nc = curr[1] + dc[k];
                    if (nr == rLimit - 1 && nc == cLimit - 1) {
                        if (answer > lev) {
                            answer = lev;
                        }
                        break;
                    } else if (nr >= 0 && nr < rLimit && nc >= 0 && nc < cLimit && maps[nr][nc] == 1) {
                        queue.add(new int[]{nr, nc});
                        maps[nr][nc] = 0;
                    }
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}