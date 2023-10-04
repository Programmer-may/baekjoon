class Solution {
    public int solution(int[] numbers) {
        int[] check = new int[10];
        int answer = 0;
        for(int num : numbers){
            check[num] = 1;
        }
        for(int i = 0; i < check.length; i++){
            if(check[i] == 0) answer += i; 
        }
        return answer;
    }
}