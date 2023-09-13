import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length + 1][triangle.length + 2];
        dp[1][1] = triangle[0][0];
        if (triangle.length != 1) {
            for (int i = 2; i < triangle.length + 1; i++) {
                for (int y = 1; y < triangle[i - 1].length + 1; y++) {
                    if (dp[i - 1][y - 1] >= dp[i - 1][y]) {
                        dp[i][y] = triangle[i - 1][y - 1] + dp[i - 1][y - 1];
                    } else {
                        dp[i][y] = triangle[i - 1][y - 1] + dp[i - 1][y];
                    }
                }
            }
        }
        int answer = Arrays.stream(dp[triangle.length]).max().getAsInt();
        return answer;
    }
}