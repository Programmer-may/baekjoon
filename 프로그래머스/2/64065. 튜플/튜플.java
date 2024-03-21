import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 2; i < arr.length; ) {
            if (isNumber(arr[i])) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i]);
                for (int j = i + 1; j < arr.length; j++) {
                    if (isNumber(arr[j])) sb.append(arr[j]);
                    else {
                        i = j + 1;
                        break;
                    }
                }
                int num = Integer.parseInt(sb.toString());
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                i++;
            }
        }
        int[] answer = new int[map.keySet().size()];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll()[0];
        }
        return answer;
    }

    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}