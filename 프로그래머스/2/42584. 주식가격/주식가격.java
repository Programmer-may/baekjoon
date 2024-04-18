import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> priceQueue = new LinkedList<>();
        for (int price : prices) {
            priceQueue.add(price);
        }
        int idx = 0;
        while (!priceQueue.isEmpty()) {
            int nowPrice = priceQueue.poll();
            answer[idx] = 0;
            for (Integer price : priceQueue) {
                answer[idx]++;
                if (nowPrice > price) break;
            }
            idx++;
        }
        return answer;
    }
}