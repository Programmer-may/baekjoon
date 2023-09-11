class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int y = i; y <= n; y++) {
                tmp += y;
                if (tmp == n) {
                    answer++;
                    break;
                } else if (tmp > n) {
                    break;
                }
            }
        }
        return answer;
    }
}