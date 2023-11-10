class Solution {
    public int solution(int n) {
        int answer = 0;
        String trit = Integer.toString(n, 3);
        char[] tritArr = trit.toCharArray();
        int left = 0;
        int right = tritArr.length - 1;
        while (left < right) {
            char tmp;
            tmp = tritArr[right];
            tritArr[right] = tritArr[left];
            tritArr[left] = tmp;
            left++;
            right--;
        }
        for (int i = tritArr.length - 1; i >= 0; i--) {
            answer += Integer.parseInt(String.valueOf(tritArr[i])) * Math.pow(3, tritArr.length - 1 - i);
        }
        return answer;
    }
}