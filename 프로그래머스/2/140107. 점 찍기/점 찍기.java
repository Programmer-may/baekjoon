class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long max = (long) d * d;


        for (int x = 0; x <= d; x += k) {
            long xSquare = (long) x * x;
            long left = 0;
            long right = d;


            while (left <= right) {
                long mid = (left + right) / 2;
                long ySquare = mid * mid;

                if (xSquare + ySquare <= max) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            answer += (right / k) + 1;
        }

        return answer;
    }
}