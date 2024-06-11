class Solution {
    public int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        if (n == 1 && m == 1) {
            return board[n - 1][m - 1];
        }
        int[][] dp = new int[n][m];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            dp[0][i] = board[0][i];
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = board[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] , dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}