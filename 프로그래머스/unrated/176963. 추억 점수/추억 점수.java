import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for (int i = 0; i < answer.length; i++) {
            for (int y = 0; y < photo[i].length; y++) {
                answer[i] += map.getOrDefault(photo[i][y], 0);
            }
        }
        return answer;
    }
}