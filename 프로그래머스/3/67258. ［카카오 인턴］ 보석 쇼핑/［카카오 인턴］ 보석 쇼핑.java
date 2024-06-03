import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int start = 0, end = 0;
        int[] answer = new int[2];
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        int gemsType = set.size();
        for (int i = 0; i < gems.length; i++) {
            if (!map.containsKey(gems[i])) {
                map.put(gems[i], i);
                end = i;
                if (map.size() == gemsType) answer = new int[]{start + 1, end + 1};
            } else {
                map.put(gems[i], i);
                end = i;
                if (gems[start].equals(gems[i])) {
                    int tmp = Integer.MAX_VALUE;
                    for (String key : map.keySet()) {
                        tmp = Math.min(tmp, map.get(key));
                    }
                    if (tmp == Integer.MAX_VALUE) start = 0;
                    else start = tmp;
                    if (answer[1] - answer[0] > end - start) {
                        answer = new int[]{start + 1, end + 1};
                    }
                }
            }
        }
        return answer;
    }
}