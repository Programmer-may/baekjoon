import java.util.*;

class Solution {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private class Road {
        public final int x;
        public final int y;
        public final int cost;
        public final int dir;

        public Road(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] costs = new int[n][n][4]; // 3차원 배열 사용

        // 초기화: 모든 위치의 비용을 최대값으로 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }

        // BFS 초기 설정
        Queue<Road> queue = new LinkedList<>();
        queue.add(new Road(0, 0, 0, -1)); // 시작점 (0, 0)에서 출발, 초기 비용 0, 방향 없음
        Arrays.fill(costs[0][0], 0);

        while (!queue.isEmpty()) {
            Road current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int currentCost = current.cost;
            int currentDir = current.dir;

            // 목적지에 도달한 경우
            if (cx == n - 1 && cy == n - 1) {
                continue;
            }

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 이동 가능한 범위인지 확인
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[ny][nx] == 0) {
                    int newCost = currentCost + 100; // 직선 도로 비용
                    if (currentDir != -1 && currentDir != i) {
                        newCost += 500; // 코너 비용
                    }

                    // 새로운 비용이 기존 비용보다 작은 경우 갱신
                    if (newCost < costs[ny][nx][i]) {
                        costs[ny][nx][i] = newCost;
                        queue.add(new Road(nx, ny, newCost, i));
                    }
                }
            }
        }

        // 도착점에서 최소 비용 찾기
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minCost = Math.min(minCost, costs[n - 1][n - 1][i]);
        }

        return minCost;
    }
}