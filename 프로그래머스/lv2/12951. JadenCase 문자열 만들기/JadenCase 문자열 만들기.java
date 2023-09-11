import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder jadenCase = new StringBuilder();
        while (st.hasMoreTokens()) {
            String[] subStirng = st.nextToken().split("");
            jadenCase.append(subStirng[0].toUpperCase());
            for (int y = 1; y < subStirng.length; y++) {
                jadenCase.append(subStirng[y].toLowerCase());
            }
        }
        return jadenCase.toString();
    }
}