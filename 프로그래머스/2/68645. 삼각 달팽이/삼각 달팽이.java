import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new int[i]);
        }
        int start = 1;
        int end = 0;
        for (int i = n; i >= 1; i--) {
            end += i;
        }
        int idx = 0;
        int dir = 3;
        int insert = 0;
        while (start <= end) {
            if (dir % 3 == 0) {
                idx++;
                for (int i = 0; i < n; i++) {
                    list.get(idx++)[insert] = start++;
                }
                n--;
                dir--;
            } else if (dir % 3 == 2) {
                idx--;
                for (int i = 0; i < n; i++) {
                    list.get(idx)[++insert] = start++;
                }
                n--;
                dir--;
            } else {
                for (int i = 0; i < n; i++) {
                    list.get(--idx)[--insert] = start++;
                }
                n--;
                dir = 3;
            }
        }
        int[] answer = new int[end];
        int i = 0;
        for (int[] arr : list) {
            for (int num : arr) {
                answer[i++] = num;
            }
        }
        return answer;
    }
}