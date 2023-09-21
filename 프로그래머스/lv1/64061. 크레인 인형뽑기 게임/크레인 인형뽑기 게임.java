import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
            int line = moves[i];
            for (int y = 0; y < board.length; y++) {
                if (board[y][line-1] !=0){
                    int tmp = board[y][line-1];
                    board[y][line-1] = 0;
                    if (!stack.isEmpty() && stack.peek() == tmp){
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(tmp); 
                    }
                    break;
                }
            }
        }
        return answer;
    }
}