import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1; // 하나의 기지국이 커버하는 범위
        int lastCovered = 0; // 마지막으로 커버된 아파트 위치

        for (int station : stations) {
            int start = station - w; // 현재 기지국이 커버하는 시작 위치
            int end = station + w; // 현재 기지국이 커버하는 끝 위치

            // 현재 기지국이 커버하지 않는 구간의 길이 계산
            if (lastCovered + 1 < start) {
                int gap = start - lastCovered - 1;
                answer += (gap + coverage - 1) / coverage; // 필요한 기지국 수 계산
            }
            
            lastCovered = end; // 마지막 커버된 위치 갱신
        }

        // 마지막 기지국 이후의 아파트들에 대한 처리
        if (lastCovered < n) {
            int gap = n - lastCovered;
            answer += (gap + coverage - 1) / coverage; // 필요한 기지국 수 계산
        }

        return answer;
    }
}