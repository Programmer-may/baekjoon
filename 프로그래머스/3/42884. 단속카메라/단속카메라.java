import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        
        int answer = 1;
        int camera = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            int enter = routes[i][0];
            int out = routes[i][1];
            if (camera < enter) {
                answer++;
                camera = out;
            }
        }
        return answer;
    }
}