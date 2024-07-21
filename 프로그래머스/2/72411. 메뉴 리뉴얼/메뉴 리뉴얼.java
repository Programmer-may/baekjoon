import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        Map<String, Integer> combCountMap = new HashMap<>();

        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            for (int c : course) {
                if (chars.length >= c) {
                    generateCombinations(chars, new StringBuilder(), 0, c, combCountMap);
                }
            }
        }

        for (int c : course) {
            int maxCount = 0;
            List<String> maxCombList = new ArrayList<>();
            for (String comb : combCountMap.keySet()) {
                if (comb.length() == c) {
                    int count = combCountMap.get(comb);
                    if (count > maxCount) {
                        maxCount = count;
                        maxCombList.clear();
                        maxCombList.add(comb);
                    } else if (count == maxCount) {
                        maxCombList.add(comb);
                    }
                }
            }
            if (maxCount >= 2) {
                answerList.addAll(maxCombList);
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    private void generateCombinations(char[] chars, StringBuilder sb, int start, int length, Map<String, Integer> combCountMap) {
        if (sb.length() == length) {
            String comb = sb.toString();
            combCountMap.put(comb, combCountMap.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            sb.append(chars[i]);
            generateCombinations(chars, sb, i + 1, length, combCountMap);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}