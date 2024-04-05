import java.util.*;

class Solution {  
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] answerArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answerArr[i] = String.valueOf(numbers[i]);
        }
        Comparator<String> customComparator = (s1, s2) -> {
            while(true) {
                if(s1.length() ==  s2.length())
                    return s2.compareTo(s1);
                if(s1.length() <  s2.length()) {
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) != s2.charAt(i))
                            return s2.substring(i, i + 1).compareTo(s1.substring(i, i + 1));
                    }
                    s2 = s2.substring(s1.length());
                }
                if(s1.length() >  s2.length()) {
                    for (int i = 0; i < s2.length(); i++) {
                        if (s1.charAt(i) != s2.charAt(i))
                            return s2.substring(i, i + 1).compareTo(s1.substring(i, i + 1));
                    }
                    s1 = s1.substring(s2.length());
                }
            }
        };
        // Comparator를 사용하여 배열 정렬
        Arrays.sort(answerArr, customComparator);
        for (String item : answerArr) {
            sb.append(item);
        }
        return sb.charAt(0) == '0' ? "0" : String.valueOf(sb);
    }
}