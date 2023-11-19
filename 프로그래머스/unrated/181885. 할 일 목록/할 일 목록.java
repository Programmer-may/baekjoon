import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) list.add(todo_list[i]);
        }
        String[] answer = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            answer[idx++] = s;
        }
        return answer;
    }
}