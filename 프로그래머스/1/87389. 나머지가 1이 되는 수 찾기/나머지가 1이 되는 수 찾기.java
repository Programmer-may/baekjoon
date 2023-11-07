class Solution {
    public int solution(int n) {
        // n - 1 을 한 수가 어떤 수의 배수인 경우와 소수인 경우 2가지 케이스가 있을 수 있다.
        if(isPrimeNumber(n -1)){
            return n - 1;
        }
        return smallestMultiple(n - 1);
    }
    public boolean isPrimeNumber(int num) {
        for(int i = 2; i < num / 2; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public int smallestMultiple(int num) {
        
        for(int i = 2; i < num /2; i ++) {
            if(num % i == 0) return i;
        }
        return 0;
    }
}