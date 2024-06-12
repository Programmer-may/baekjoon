class Solution {
    public int[] solution(int target) {
        // 점수와 각 점수에 대한 다트 수와 싱글/불 개수를 저장할 DP 배열
        int[][] dp = new int[target + 1][2]; // dp[i][0]: 최소 다트 수, dp[i][1]: 싱글/불 개수

        // 초기값 설정
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        // 가능한 모든 점수
        int[] scores = new int[61];
        int index = 0;

        // 싱글 점수 (1-20)
        for (int i = 1; i <= 20; i++) {
            scores[index++] = i;
        }

        // 더블 점수 (2-40)
        for (int i = 1; i <= 20; i++) {
            scores[index++] = i * 2;
        }

        // 트리플 점수 (3-60)
        for (int i = 1; i <= 20; i++) {
            scores[index++] = i * 3;
        }

        // 불 (50)
        scores[index++] = 50;

        // DP 배열 채우기
        for (int i = 0; i < index; i++) {
            int score = scores[i];
            for (int j = score; j <= target; j++) {
                if (dp[j - score][0] + 1 < dp[j][0]) {
                    dp[j][0] = dp[j - score][0] + 1;
                    dp[j][1] = dp[j - score][1] + (score == 50 || score <= 20 ? 1 : 0);
                } else if (dp[j - score][0] + 1 == dp[j][0]) {
                    dp[j][1] = Math.max(dp[j][1], dp[j - score][1] + (score == 50 || score <= 20 ? 1 : 0));
                }
            }
        }

        return new int[]{dp[target][0], dp[target][1]};
    }
}