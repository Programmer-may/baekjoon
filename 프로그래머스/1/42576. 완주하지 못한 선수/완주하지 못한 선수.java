import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> check = new HashMap<>();
        String answer = "";
        for(String name : participant){
            check.put(name, check.getOrDefault(name, 0) + 1);
        }
        for(String name : completion){
            check.put(name , check.get(name) - 1);
        }
        for(String name : check.keySet()){
            if(check.get(name) > 0) {
                answer = name;
                break;
            }
        }
        return answer;
    }
}