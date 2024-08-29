import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> length = new ArrayList<>();
        List<Integer> width = new ArrayList<>();
        for (int[] card : sizes) {
            Arrays.sort(card);
            width.add(card[0]);
            length.add(card[1]);
        }
        length.sort(Collections.reverseOrder());
        width.sort(Collections.reverseOrder());
        return length.get(0) * width.get(0);
    }
}