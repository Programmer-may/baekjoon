import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int minOfMaxs = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            // 현재 슬라이딩 윈도우의 범위 밖의 인덱스를 제거
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 덱의 뒷부분에서 현재 원소보다 작은 값을 제거
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            // 현재 원소의 인덱스를 덱에 추가
            deque.offerLast(i);

            // 슬라이딩 윈도우의 크기가 k가 될 때마다 최소값을 업데이트
            if (i >= k - 1) {
                minOfMaxs = Math.min(minOfMaxs, stones[deque.peekFirst()]);
            }
        }

        return minOfMaxs;
    }
}