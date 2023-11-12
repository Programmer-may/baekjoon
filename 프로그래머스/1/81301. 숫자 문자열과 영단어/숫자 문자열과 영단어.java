import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<String, int[]> map = new HashMap<>();
        map.put("ze", new int[] {0, 4});
        map.put("on", new int[] {1, 3});
        map.put("tw", new int[] {2, 3});
        map.put("th", new int[] {3, 5});
        map.put("fo", new int[] {4, 4});
        map.put("fi", new int[] {5, 4});
        map.put("si", new int[] {6, 3});
        map.put("se", new int[] {7, 5});
        map.put("ei", new int[] {8, 5});
        map.put("ni", new int[] {9, 4});
        
        for (int i = 0; i < s.length();){
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57){
                sb.append(s.charAt(i));
                i++;
            } else {
                String fragment = s.substring(i, i + 2);
                sb.append(map.get(fragment)[0]);
                i += map.get(fragment)[1];
            }
        }
        return Integer.parseInt(sb.toString());
    }
}