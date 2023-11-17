import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            if (my_string.charAt(i) == ' ') {
                list.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(my_string.charAt(i));
            }
        }
        list.add(sb.toString());
        String[] answer = new String[list.size()];
        int i = 0;
        for (String str : list) {
            answer[i++] = str;
        }
        return answer;
    }
}