import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> tasks = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            tasks.add((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }
        List<Integer> answer = new ArrayList<>();
        while (!tasks.isEmpty()) {
            int now = tasks.poll();
            int next = tasks.isEmpty() ? 101 : tasks.peek();
            int cnt = 1;
            while (!tasks.isEmpty() && now >= next) {
                cnt++;
                tasks.poll();
                next = tasks.isEmpty() ? 101 : tasks.peek();
            }
            answer.add(cnt);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}