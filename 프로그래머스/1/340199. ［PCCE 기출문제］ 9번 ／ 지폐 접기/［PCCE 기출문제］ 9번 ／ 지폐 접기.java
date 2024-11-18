class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        boolean isDone = false;
        int maxSize = Math.max(wallet[0], wallet[1]);
        int minSize = Math.min(wallet[0], wallet[1]);
        int billMaxSize = Math.max(bill[0], bill[1]);
        int billMinSize = Math.min(bill[0], bill[1]);
        while(!isDone) {
            if (maxSize >= billMaxSize && minSize >= billMinSize) {
                isDone = true;
            } else {
                int tmp = billMaxSize / 2;
                billMaxSize = Math.max(tmp, billMinSize);
                billMinSize = Math.min(tmp, billMinSize);
                answer++;
            }
        }
        return answer;
    }
}