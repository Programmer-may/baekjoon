import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        Set<Integer> set = new HashSet<>();
        
        int[] extended = new int[2 * length];
        for (int i = 0; i < length; i++) {
            extended[i] = elements[i];
            extended[i + length] = elements[i];
        }
        
        for (int subLength = 1; subLength <= length; subLength++) {
            for (int start = 0; start < length; start++) {
                int sum = 0;
                for (int k = 0; k < subLength; k++) {
                    sum += extended[start + k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}