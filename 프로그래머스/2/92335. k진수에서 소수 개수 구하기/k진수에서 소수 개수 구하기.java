class Solution {
    public int solution(int n, int k) {
        char[] transNum = Integer.toString(n, k).toCharArray();
        int answer = 0;
        for (int i = 0; i < transNum.length;) {
            if(transNum[i] != '0') {
                StringBuilder sb = new StringBuilder();
                sb.append(transNum[i]);
                int next = i + 1;
                while (next < transNum.length && transNum[next] != '0') {
                    sb.append(transNum[next++]);
                }
                i = next;
                long num = Long.parseLong(sb.toString());
                if (num != 1 && isPrimeNum(num)) answer++;
            } else {
                i++;
            }
        }
        return answer;
    }
    private boolean isPrimeNum(long  num) {
        for (long  i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}