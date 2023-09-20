import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[][] matrix = new char[4][2];
        matrix[0][0] = 'R';
        matrix[0][1] = 'T';
        matrix[1][0] = 'C';
        matrix[1][1] = 'F';
        matrix[2][0] = 'J';
        matrix[2][1] = 'M';
        matrix[3][0] = 'A';
        matrix[3][1] = 'N';
        for (int i = 0; i < survey.length; i++) {
            char front = survey[i].charAt(0);
            char behind = survey[i].charAt(1);
            if (choices[i] >= 5) {
                map.put(behind, map.getOrDefault(behind, 0) + choices[i] % 4);
            } else if (choices[i] <= 3) {
                map.put(front, map.getOrDefault(front, 0) + (4 - choices[i]));
            }
        }
        String answer = "";
        for (int i = 0; i < 4; i++) {
            char front = matrix[i][0];
            char behind = matrix[i][1];
            if (map.getOrDefault(front, 0) > map.getOrDefault(behind, 0)) {
                answer += front;
            } else if (map.getOrDefault(front, 0) < map.getOrDefault(behind, 0)) {
                answer += behind;
            } else {
                if (front < behind) {
                    answer += front;
                } else {
                    answer += behind;
                }
            }
        }
        return answer;
    }
}