import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> isVisited = new HashSet<>();
        queue.add(x);
        isVisited.add(x);
        int answer = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num == y) {
                    return answer;
                }                
                int[] nextNums = {num * 2, num * 3, num + n};                
                for (int nextNum : nextNums) {
                    if (nextNum <= y && !isVisited.contains(nextNum)) {
                        queue.add(nextNum);
                        isVisited.add(nextNum);
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}
