class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int x = 0; x < number.length - 2; x++) {
            for (int y = x + 1; y < number.length - 1; y++) {
                for (int z = y + 1; z < number.length; z++) {
                    if(number[x] + number[y] + number[z] == 0) {
                        answer++;
                    }
                }

            }
        }
        return answer;
    }
}