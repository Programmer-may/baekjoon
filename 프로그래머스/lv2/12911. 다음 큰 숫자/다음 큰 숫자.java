class Solution {
    public int solution(int n) {
        int answer = 0;
        int cntOneOfN = countOne(binaryConversion(n));
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            if (countOne(binaryConversion(i)) == cntOneOfN) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static String binaryConversion(int num) {
        String binaryNum = Integer.toBinaryString(num);
        return binaryNum;
    }

    public static int countOne(String binaryNum) {
        int cntOne = 0;
        for (int i = 0; i < binaryNum.length(); i++) {
            if (binaryNum.charAt(i) == '1') {
                cntOne++;
            }
        }
        return cntOne;
    }
}