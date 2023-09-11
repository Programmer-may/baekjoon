class Solution {
    static int[] answer = new int[2];
    static int reduceZero =0;
    static int round =0;
    
    public int[] solution(String s) {
        while (!s.equals("1")) {
            String[] sArr = s.split("");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i].equals("0")) {
                    reduceZero++;
                } else {
                    sb.append(sArr[i]);
                }
            }
            s = sb.toString();
            int lengthAfterReduce = s.length();
            s = binaryConversion(lengthAfterReduce);
        }
        answer[0] = round;
        answer[1] = reduceZero;

        return answer;
    }
    public static String binaryConversion(int lengthAfterReduce) {
        String binaryString = Integer.toBinaryString(lengthAfterReduce);
        round++;
        return binaryString;
    }
}