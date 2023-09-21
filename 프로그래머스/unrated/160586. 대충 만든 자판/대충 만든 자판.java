import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            String[] oneKeyMap = keymap[i].split("");
            for (int y = 0; y < oneKeyMap.length; y++) {
                String alp = oneKeyMap[y];
                if (!map.containsKey(alp)) {
                    map.putIfAbsent(alp, new int[2]);
                    map.get(alp)[0] = i+1;
                    map.get(alp)[1] = y+1;
                } else {
                    if (map.get(alp)[0] != i+1) {
                        if (map.get(alp)[1] > y+1) {
                            map.get(alp)[0] = i+1;
                            map.get(alp)[1] = y+1;
                        }
                    }
                }
            }
        }
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String[] target = targets[i].split("");
            for (int y = 0; y < target.length; y++) {
                String alp = target[y];
                if (map.containsKey(alp)) {
                    answer[i] += map.get(alp)[1];
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}