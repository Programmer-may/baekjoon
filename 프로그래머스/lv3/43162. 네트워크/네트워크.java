import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                int cntNum = 0;
                for (int j = 0; j < n; j++) {
                    if (computers[i][j] == 1) {
                        cntNum++;
                    }
                }
                if (cntNum == 1) {
                    answer++;
                    visited.add(i);
                } else {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    while (!queue.isEmpty()) {
                        int computerNum = queue.poll();
                        if (!visited.contains(computerNum)) {
                            for (int y = 0; y < n; y++) {
                                if (computers[computerNum][y] == 1) {
                                    queue.add(y);
                                }
                            }
                        }
                        visited.add(computerNum);
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}