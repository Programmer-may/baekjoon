import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        while (n--> 0) {
            if (!pq.isEmpty()) {
                int work = pq.poll();
            if (--work != 0) pq.add(work);
            }
        }
        long answer = 0;
        if (pq.isEmpty()) {
            return answer;
        } else {
            for (int work : pq) {
                answer += Math.pow(work, 2);
            }
            return answer;
        }
    }
}