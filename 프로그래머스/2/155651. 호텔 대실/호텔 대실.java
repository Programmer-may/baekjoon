import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] book_minTime = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            String start = book_time[i][0];
            String end = book_time[i][1];
            book_minTime[i][0] = covertTime(start);
            book_minTime[i][1] = covertTime(end);
        }
        Arrays.sort(book_minTime, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(book_minTime[0]);
        for (int i = 1; i < book_minTime.length; i++) {
            if (pq.peek()[1] + 10 > book_minTime[i][0]) {
                pq.add(book_minTime[i]);
            } else {
                pq.poll();
                pq.add(book_minTime[i]);
            }
        }
        return pq.size();
    }

    public int covertTime(String str) {
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}