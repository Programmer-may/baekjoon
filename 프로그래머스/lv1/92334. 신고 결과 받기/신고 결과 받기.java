import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            String id = report[i].split(" ")[0];
            String reportId = report[i].split(" ")[1];
            if (!set.contains(report[i])) {
                map.put(reportId, map.getOrDefault(reportId, 0) + 1);
                reportMap.putIfAbsent(id, new HashSet<>());
                reportMap.get(id).add(reportId);
                set.add(report[i]);
            }
        }
        int[] answer = new int[id_list.length];
        int idx = 0;
        for (String id : id_list) {
            int tmp = 0;
            if (reportMap.containsKey(id)){
                for (String name : reportMap.getOrDefault(id,null)) {
                    if (map.getOrDefault(name, 0) >= k) {
                        tmp++;
                    }
                }
            }
            answer[idx] = tmp;
            idx++;
        }
        return answer;
    }
}