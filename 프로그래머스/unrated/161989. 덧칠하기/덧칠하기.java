import java.util.Stack;

class Solution {
    public int solution(int n, int m, int[] section) {
        Stack<Integer> stack = new Stack<>();
        int max = n-4;
        for (int i =0; i<section.length;i++){
            if (stack.isEmpty() || stack.peek() + m -1<section[i]){
                stack.push(section[i]);
            }
        }
        return stack.size();
    }
}