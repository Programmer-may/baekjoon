class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i = 1; i <= count; i++) {
            answer += price * i;
        }
        return money - answer < 0 ? Math.abs(answer - money) : 0;
    }
}