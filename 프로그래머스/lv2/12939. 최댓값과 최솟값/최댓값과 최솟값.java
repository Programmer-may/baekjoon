import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int[] preAnswer = new int[sArr.length];
        for (int i = 0; i < preAnswer.length; i++) {
            preAnswer[i] = Integer.parseInt(sArr[i]);
        }
        Arrays.sort(preAnswer);
        String max = String.valueOf(preAnswer[preAnswer.length - 1]);
        String min = String.valueOf(preAnswer[0]);
        String answer = min + " " + max;
        return answer;
    }
}