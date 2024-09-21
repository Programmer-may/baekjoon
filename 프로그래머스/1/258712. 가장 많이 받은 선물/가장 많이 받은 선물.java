import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, int[]> map = new HashMap<>();
        int idx = 0;
        for (String friend : friends) {
            map.put(friend, new int[2]);
            map.get(friend)[0] = idx++;
        }
        int[][] matrix = new int[friends.length][friends.length];
        for (String giftInfo : gifts) {
            String[] rel = giftInfo.split(" ");
            String from = rel[0];
            String to = rel[1];
            matrix[map.get(from)[0]][map.get(to)[0]]++;
            map.get(from)[1]++;
            map.get(to)[1]--;
        }
        List<Integer> candidate = new ArrayList<>();
        for (String me : friends) {
            int tmp = 0;
            for (String friend : friends) {
                if (!me.equals(friend)) {
                    if (matrix[map.get(me)[0]][map.get(friend)[0]] > matrix[map.get(friend)[0]][map.get(me)[0]]) tmp++;
                    else if (matrix[map.get(me)[0]][map.get(friend)[0]] == matrix[map.get(friend)[0]][map.get(me)[0]]
                            && map.get(me)[1] > map.get(friend)[1]) tmp++;
                }
            }
            candidate.add(tmp);
        }
        Collections.sort(candidate, Collections.reverseOrder());
        return candidate.get(0);
    }
}