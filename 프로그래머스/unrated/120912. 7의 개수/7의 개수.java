class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int num : array) {
            while(num > 0) {
                int tmp = num % 10;
                if(tmp == 7) answer++;
                num = num / 10;
            }
        }
        return answer;
    }
}