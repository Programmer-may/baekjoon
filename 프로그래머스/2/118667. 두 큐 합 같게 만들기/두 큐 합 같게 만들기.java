import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total1 = 0;
        long total2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            total1 += queue1[i];
            q1.add(queue1[i]);
            total2 += queue2[i];
            q2.add(queue2[i]);
        }
        if (total1 == total2) return 0;
        if ((total1 + total2) % 2 != 0) return -1;
        long target = (total1 + total2) / 2;
        while (answer < queue1.length * 3 && total1 != target) {
            if (total1 > total2) {
                int num = q1.poll();
                total1 -= num;
                q2.add(num);
                total2 += num;
            } else if (total1 < total2) {
                int num = q2.poll();
                total2 -= num;
                q1.add(num);
                total1 += num;
            }
            answer++;
        }
        return total1 == target ? answer : -1;
    }
}