import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        String[] split = s.split("");
        Stack<String> stack = new Stack<>();

        for (String oneString : split) {
            if (!stack.isEmpty() && stack.peek().equals(oneString)) {
                stack.pop();
            } else {
                stack.push(oneString);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}