class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        for(int i = 0; i < num; i++){
            answer[i] = i+1;
            total -= (i+1);
        }
        for(int i = 0; i < num; i++){
            answer[i] += (total/num);
        }
        return answer;
    }
}