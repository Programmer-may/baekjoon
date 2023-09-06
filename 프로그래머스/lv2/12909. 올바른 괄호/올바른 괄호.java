import java.util.LinkedList;
import java.util.Queue;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                queue.add(s.charAt(i));
            } else {
                if (queue.isEmpty()) {
                    queue.add(s.charAt(i));
                }
                if (queue.peek() == '(') {
                    queue.poll();
                } else {
                    queue.add(s.charAt(i));
                }
            }
        }
        if (queue.isEmpty()) {
            return answer;
        }
        return !answer;
    }
}