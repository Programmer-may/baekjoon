import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!hasTarget(target, words)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        int answer = 0;
        queue.add(begin);
        while (!queue.isEmpty() || answer <= words.length) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String now = queue.poll();
                if (now.equals(target)) return answer;
                for (String word : words) {
                    if (!visited.contains(word) && isPossible(now, word)) {
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
    
    boolean hasTarget(String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) return true;
        }
        return false;
    }
    
    boolean isPossible(String before, String after) {
        int len = before.length();
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            if (before.charAt(i) == after.charAt(i)) tmp++;
        }
        if (tmp == len - 1) return true;
        return false;
    }
}