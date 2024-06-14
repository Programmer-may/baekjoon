import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int size = enemy.length;
        if (k >= size) return size;
        int left = 0;
        int right = size;
        //4 6 10 15 18 21 22
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canDefend(n, k, enemy, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }

    private boolean canDefend(int n, int k, int[] enemy, int rounds) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < rounds; i++) {
            pq.offer(enemy[i]);
            n -= enemy[i];

            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}