class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int j : ingredient) {
            sb.append(j);
            if (sb.length() > 3 && sb.subSequence(sb.length() - 4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length());
            }
        }
        return answer;
    }
}