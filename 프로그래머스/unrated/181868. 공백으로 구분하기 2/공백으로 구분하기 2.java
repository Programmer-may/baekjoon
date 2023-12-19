import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] tmp = my_string.split(" ");
        ArrayList<String> al = new ArrayList<>();
        for(String x : tmp){
            if(x.equals("")) continue;
            al.add(x);
        }
        String[] answer = new String[al.size()];
        for(int i = 0; i < al.size(); i++) answer[i] = al.get(i);
        return answer;

    }
}