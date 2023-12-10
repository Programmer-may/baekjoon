class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int left = 0;
        int right = pat.length() - 1;
        while(right <= myString.length() - 1) {
            if (myString.substring(left, right + 1).equals(pat)) answer++;
            left++;
            right++;
        }
        return answer;
    }
}