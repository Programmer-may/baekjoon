import java.util.*;

class Solution {
    class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public int solution(String begin, String target, String[] words) {
        List<String> wordsList = Arrays.asList(words);
        if (!wordsList.contains(target)) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, 0));

        Set<String> visited = new HashSet<>();
        visited.add(begin);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentWord = current.word;
            int currentSteps = current.steps;

            if (currentWord.equals(target)) {
                return currentSteps;
            }

            for (String word : words) {
                if (!visited.contains(word) && canTransform(currentWord, word)) {
                    visited.add(word);
                    queue.add(new Pair(word, currentSteps + 1));
                }
            }
        }

        return 0;
    }
    
    private boolean canTransform(String word1, String word2) {
        int difference = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                difference++;
            }
            if (difference > 1) {
                return false;
            }
        }
        return difference == 1;
    }
}