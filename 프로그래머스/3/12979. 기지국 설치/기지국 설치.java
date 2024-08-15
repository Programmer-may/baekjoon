import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int lastCovered = 0;

        for (int station : stations) {
            int start = station - w; 
            int end = station + w; 
            if (lastCovered + 1 < start) {
                int gap = start - lastCovered - 1;
                answer += (gap + coverage - 1) / coverage; 
            }
            
            lastCovered = end; 
        }        
        if (lastCovered < n) {
            int gap = n - lastCovered;
            answer += (gap + coverage - 1) / coverage; 
        }

        return answer;
    }
}