import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        if (words[0].length() == 1){
            answer[0]= 1;
            answer[1]= 1;
            return answer;
        } else {
            set.add(words[0]);
        }
        for (int i = 1; i < words.length; i++) {
            char endChar = words[i - 1].charAt(words[i - 1].length() - 1);
            char firstChar = words[i].charAt(0);
            if (endChar == firstChar && !set.contains(words[i]) && words[i].length() != 1) {
                set.add(words[i]);
            } else {
                if (((i + 1) % n) == 0) {
                    int person = n;
                    int round = (i + 1) / n;
                    answer[0] = person;
                    answer[1] = round;
                } else {
                    int person = (i + 1) % n;
                    int round = (i + 1) / n + 1;
                    answer[0] = person;
                    answer[1] = round;
                }
                break;
            }
        }
        return answer;
    }
}