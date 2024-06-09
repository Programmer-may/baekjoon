class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = Long.MAX_VALUE / 100;    
        while(left < right){
            long mid = (left + right) / 2;
            long tmp = calculate(mid, times);
            if(n <= tmp){
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }
    long calculate(long mid, int[] times){
        long sum = 0;
        for(int i = 0; i < times.length; i++){
            sum += mid / times[i];
        }
        return sum;
    }
}