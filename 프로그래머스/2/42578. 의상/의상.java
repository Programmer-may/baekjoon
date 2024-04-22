import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] combination : clothes) {
            map.put(combination[1], map.getOrDefault(combination[1], 0) + 1);
        }
        int answer = 1;
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        return answer - 1;
    }
}