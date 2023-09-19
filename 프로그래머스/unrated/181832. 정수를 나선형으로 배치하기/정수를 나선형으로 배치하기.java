class Solution {
    public int[][] solution(int n) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int r = 0, c = 0;
        int d = 1;
        int cnt = 1;
        int[][] answer = new int[n][n];
        answer[0][0] = 1;
        while (cnt < n * n) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] != 0) {
                d = (d + 1) % 4;
            } else {
                r = nr;
                c = nc;
                answer[r][c] = ++cnt;
            }
        }
        return answer;
    }
}