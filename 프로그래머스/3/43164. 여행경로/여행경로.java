import java.util.*;

class Solution {
    public static String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).add(to);
        }
        List<String> result = new LinkedList<>();
        dfs("ICN", map, result);
        return result.toArray(new String[result.size()]);
    }

    private static void dfs(String current, Map<String, PriorityQueue<String>> map, List<String> result) {
        PriorityQueue<String> nextCities = map.get(current);
        while (nextCities != null && !nextCities.isEmpty()) {
            dfs(nextCities.poll(), map, result);
        }
        result.add(0, current);  // 역순으로 결과를 추가합니다.
    }
}