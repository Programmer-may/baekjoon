import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        long startR = left / n;
        long startC = left % n;
        long endR = right / n;
        long endC = right % n;
        int idx = 0;
        while (idx <= answer.length - 1) {
            answer[idx++] = (int) Math.max(startR, startC) + 1;
            startC++;
            if (startC == n) {
                startR++;
                startC = 0L;
            }
        }
        return answer;
    }
}