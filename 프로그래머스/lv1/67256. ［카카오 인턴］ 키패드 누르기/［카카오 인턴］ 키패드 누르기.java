class Solution {
    public String solution(int[] numbers, String hand) {
        int[] numLevel = new int[13];
        numLevel[0] = 4;
        for (int i = 1; i < numLevel.length; i++) {

            numLevel[i] = (i - 1) / 3 + 1;
        }
        int[] numStep = new int[13];
        numStep[0] = 2;
        for (int i = 1; i < numStep.length; i++) {
            if (i % 3 == 1) {
                numStep[i] = 1;
            } else if (i % 3 == 2) {
                numStep[i] = 2;
            } else {
                numStep[i] = 3;
            }
        }
        int leftPosition = 10;
        int rightPosition = 12;
        StringBuilder answer = new StringBuilder();
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftPosition = num;
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightPosition = num;
            } else {
                int leftLevelDepth = Math.abs(numLevel[leftPosition] - numLevel[num]);
                int leftStepDepth = Math.abs(numStep[leftPosition] - numStep[num]);
                int rightLevelDepth = Math.abs(numLevel[rightPosition] - numLevel[num]);
                int rightStepDepth = Math.abs(numStep[rightPosition] - numStep[num]);
                if ((leftLevelDepth + leftStepDepth) > (rightLevelDepth + rightStepDepth)) {
                    answer.append("R");
                    rightPosition = num;
                } else if ((leftLevelDepth + leftStepDepth) < (rightLevelDepth + rightStepDepth)) {
                    answer.append("L");
                    leftPosition = num;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        rightPosition = num;
                    } else {
                        answer.append("L");
                        leftPosition = num;
                    }
                }
            }
        }
        return answer.toString();
    }
}