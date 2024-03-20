import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine) map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : map.values()) pq.add(i);
        while(k > 0) {
            k = k - pq.poll();
            answer++;
        }
        return answer;
    }
}