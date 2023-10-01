class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String tmp = "";
        tmp += a; 
        tmp += b;
        if(Integer.parseInt(tmp) >= 2 * a * b){
            answer = Integer.parseInt(tmp);
        } else {
            answer = 2 * a * b;
        }
        return answer;
    }
}