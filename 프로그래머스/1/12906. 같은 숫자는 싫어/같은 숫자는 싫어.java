import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (!stack.isEmpty() && stack.peek() == num) stack.pop();
            stack.push(num);
        }
        int[] answer = new int[stack.size()];
        int idx = stack.size() - 1;
        for (int num : stack) {
            answer[idx--] = num;
        }
        return answer;
    }
}