import java.util.*;

class Solution {
    public String solution(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (char alp : s.toCharArray()){
            map.put(alp , map.getOrDefault(alp,0)+1);
        }
        List<Character> list = new ArrayList<>();
        for (char key : map.keySet()){
            if(map.get(key)==1){
                list.add(key);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (char alp : list){
            sb.append(alp);
        }
        return sb.toString();
    }
}