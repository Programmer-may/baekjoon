import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] tmp = myString.split("x");
        ArrayList<String> al = new ArrayList<>();
        for(String x : tmp){
            if(x.equals("")) continue;
            al.add(x);
        }
        Collections.sort(al);
        String[] answer = new String[al.size()];
        for(int i = 0; i < al.size(); i++) answer[i] = al.get(i);
        return answer;

    }
}