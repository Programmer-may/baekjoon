import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int keep = number.length() - k;
        
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() < digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().substring(0, keep);
    }
}