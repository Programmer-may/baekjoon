import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int wrongPerson = 0;
        int round = 0;
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                int temp = (i + 1) % n;
                if (temp == 0) wrongPerson = n;
                else wrongPerson = temp;
                round = i / n + 1;
                break;
            } else {
                set.add(words[i]);
            }
        }
        
        return new int[]{wrongPerson, round};
    }
}