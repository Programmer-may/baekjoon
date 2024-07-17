import java.util.*;

class Solution {
    int oneCnt = 0;
    int zeroCnt = 0;
    public int[] solution(int[][] arr) {
        if (canCompress(0, arr.length, 0, arr.length, arr)) return new int[]{zeroCnt, oneCnt};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, arr.length, 0, arr.length});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int startR = info[0];
            int endR = info[1];
            int halfR = (startR + endR) / 2;
            int startC = info[2];
            int endC = info[3];
            int halfC = (startC + endC) / 2;
            if (!canCompress(startR, halfR, startC, halfC, arr))
                queue.add(new int[]{startR, halfR, startC, halfC});
            if (!canCompress(halfR, endR, startC, halfC, arr))
                queue.add(new int[]{halfR, endR, startC, halfC});
            if (!canCompress(startR, halfR, halfC, endC, arr))
                queue.add(new int[]{startR, halfR, halfC, endC});
            if (!canCompress(halfR, endR, halfC, endC, arr))
                queue.add(new int[]{halfR, endR, halfC, endC});
        }
        int[] answer = new int[]{zeroCnt, oneCnt};
        return answer;
    }
    private boolean canCompress(int startR, int endR, int startC, int endC, int[][] arr) {
        int standard = arr[startR][startC];
        for (int r = startR; r < endR; r++) {
            for (int c = startC; c < endC; c++) {
                if (standard != arr[r][c]) {
                    return false;
                }
            }
        }
        increaseCnt(standard);
        return true;
    }

    private void increaseCnt(int num) {
        if (num == 0) zeroCnt++;
        else oneCnt++;
    }
}