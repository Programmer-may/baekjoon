import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> process = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int order = 1;
        for (int i = 0; i < priorities.length; i++) {
            process.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }
        while (!process.isEmpty()) {
            int[] now = process.poll();
            if (pq.peek() > now[1]) {
                process.add(now);
            } else {
                if (location == now[0]) {
                    break;
                } else {
                    pq.poll();
                    order++;
                }
            }
        }
        return order;
    }
}