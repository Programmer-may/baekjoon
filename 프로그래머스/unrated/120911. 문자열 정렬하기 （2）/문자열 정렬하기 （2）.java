import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] tmp = my_string.toLowerCase().toCharArray();
        Arrays.sort(tmp);
        StringBuilder sb = new StringBuilder();
        for(char x : tmp) sb.append(x);
        return sb.toString();
    }
}