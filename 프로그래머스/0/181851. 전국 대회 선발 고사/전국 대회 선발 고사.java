import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        ArrayList<int[]> al = new ArrayList<>();
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]){
                al.add(new int[]{rank[i], i});
            }
        }
        al.sort((a, b) -> a[0] - b[0]);
        answer += al.get(0)[1] * 10000;
        answer += al.get(1)[1] * 100;
        answer += al.get(2)[1];
        return answer;
    }
}