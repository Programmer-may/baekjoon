import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = citations.length; i > 0 ; i--) {
            int tmp = 0;
            for (int j = citations.length - 1; j >= 0 ; j--) {
                if (citations[j] >= i) tmp++;
                else break;
            }
            if (tmp >= i) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}