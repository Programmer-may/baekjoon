class Solution {
    final int MAGIC_NUM = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        map[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1) {
                    if (j >= 1 && map[i][j - 1] != -1) map[i][j] +=  map[i][j - 1];
                    if (i >= 1 && map[i - 1][j] != -1) map[i][j] +=  map[i - 1][j];
                    if (map[i][j] > MAGIC_NUM) map[i][j] %= MAGIC_NUM;
                }
            }
        }
        return map[n - 1][m - 1];
    }
}