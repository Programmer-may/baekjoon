import java.util.*;

class Solution {
    Map<String,Integer> dictionary = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int idx = 1;
    public int[] solution(String msg) {
        init();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            if (dictionary.containsKey(msg.substring(i, i + 1))) {
                sb.append(msg.substring(i, i + 1));
            }
            String curr = sb.toString();
            if (!dictionary.containsKey(curr)) {
                dictionary.put(curr, idx++);
                list.add(dictionary.get(curr.substring(0, curr.length() - 1)));
                sb.delete(0, curr.length() - 1);
            }
        }
        if (sb.length() != 0) {
            list.add(dictionary.get(sb.toString()));
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    void init() {
        dictionary.put("A", idx++);
        dictionary.put("B", idx++);
        dictionary.put("C", idx++);
        dictionary.put("D", idx++);
        dictionary.put("E", idx++);
        dictionary.put("F", idx++);
        dictionary.put("G", idx++);
        dictionary.put("H", idx++);
        dictionary.put("I", idx++);
        dictionary.put("J", idx++);
        dictionary.put("K", idx++);
        dictionary.put("L", idx++);
        dictionary.put("M", idx++);
        dictionary.put("N", idx++);
        dictionary.put("O", idx++);
        dictionary.put("P", idx++);
        dictionary.put("Q", idx++);
        dictionary.put("R", idx++);
        dictionary.put("S", idx++);
        dictionary.put("T", idx++);
        dictionary.put("U", idx++);
        dictionary.put("V", idx++);
        dictionary.put("W", idx++);
        dictionary.put("X", idx++);
        dictionary.put("Y", idx++);
        dictionary.put("Z", idx++);
    }
}