import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> set1 = new LinkedList<>();
        List<String> set2 = new LinkedList<>();
        processSet(set1, str1);
        processSet(set2, str2);
        int set1Size = set1.size();
        int set2Size = set2.size();
        for (String temp : set2) {
            if (set1.contains(temp)) {
                set1.remove(temp);
            }
        }
        double jacquard;
        int intersection = set1Size - set1.size();
        int sumOfSets = set1Size + set2Size - intersection;
        if (set1.size() == 0 && set2.size() == 0) {
            jacquard = 1.0;
        } else {
            jacquard = (double)intersection / (double)sumOfSets;
        }
        return (int)(jacquard * 65536);
    }
    private void processSet(List<String> list, String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            String temp = str.substring(i , i + 2).toLowerCase();
            if (temp.charAt(0) < 'a' || temp.charAt(0) > 'z' || temp.charAt(1) < 'a' || temp.charAt(1) > 'z') continue;
            else {
                list.add(temp);
            }
        }
    }
}