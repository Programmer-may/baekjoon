import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < section.length; i++) {
            if (stack.isEmpty() || stack.peek() + m - 1 < section[i]) {
                stack.push(section[i]);
            }
        }
        return stack.size();
    }
}