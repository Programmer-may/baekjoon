import java.util.*;

class Solution {
    public int[] solution(String s) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.length() - b.length());
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) != ',' && !Character.isDigit(s.charAt(j))) {
                        pq.add(s.substring(i, j));
                        i = j + 1;
                        break;
                    }
                }
            }
        }
        List<String> answerList = new ArrayList<>();
        Set<String> elements = new HashSet<>();
        while (!pq.isEmpty()) {
            String[] current = pq.poll().split(",");
            for (String element : current) {
                if (!elements.contains(element)) {
                    answerList.add(element);
                    elements.add(element);
                }
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(answerList.get(i));
        }
        return answer;
    }
}