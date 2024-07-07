import java.util.*;

class Solution {
    Map<Character, Character> pair = new HashMap<>();
    public int solution(String s) {
        int answer = 0;
        pairInit();
        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(s)) answer++;
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(1)).append(s.substring(0, 1));
            s = sb.toString();
        }
        return answer;
    }
    private boolean isCorrect(String str) {
        if (pair.keySet().contains(str.indexOf(0))) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (!pair.keySet().contains(c)) stack.push(c);
            else {
                if (!stack.isEmpty() && (stack.peek() == pair.get(c))) stack.pop();
                else stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    private void pairInit() {
        pair.put(')','(');
        pair.put('}','{');
        pair.put(']','[');
    }
}