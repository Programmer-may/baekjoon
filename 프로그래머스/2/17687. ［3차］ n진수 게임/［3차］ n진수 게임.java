class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= t * m; i++) {
            String convertedNum = Integer.toString(i, n).toUpperCase();
            sb.append(convertedNum);
        }
        String tmp = sb.toString();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            answer.append(tmp.charAt((p - 1) + (i * m)));
        }
        return answer.toString();
    }
}