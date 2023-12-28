import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> tmp = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int x : delete_list) set.add(x);
        for(int x : arr){
            if(!set.contains(x)) tmp.add(x);
        }
        int[] answer = new int[tmp.size()];
        for(int i = 0; i < tmp.size(); i++) answer[i] = tmp.get(i);
        return answer;
    }
}