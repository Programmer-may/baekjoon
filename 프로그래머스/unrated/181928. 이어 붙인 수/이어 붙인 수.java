class Solution {
    public int solution(int[] num_list) {
        String oddNum = "";
        String evenNum = "";
        for (int num : num_list) {
            if(num % 2 == 0){
                evenNum += num;
            } else {
                oddNum += num;
            }
        }
        return Integer.parseInt(evenNum) + Integer.parseInt(oddNum);
    }
}