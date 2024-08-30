import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int oneStudentAnswerCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == i % 5 + 1) oneStudentAnswerCnt++;
        }
        int twoStudentAnswerCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (i % 2 == 0) {
                if (answer == 2) twoStudentAnswerCnt++;
            } else {
                if (i % 8 == 1 && answer == 1) twoStudentAnswerCnt++;
                if (i % 8 == 3 && answer == 3) twoStudentAnswerCnt++;
                if (i % 8 == 5 && answer == 4) twoStudentAnswerCnt++;
                if (i % 8 == 7 && answer == 5) twoStudentAnswerCnt++;
            }
        }
        int threeStudentAnswerCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if ((i % 10 == 0 || i % 10 == 1) && answer == 3) threeStudentAnswerCnt++;
            else if ((i % 10 == 2 || i % 10 == 3) && answer == 1) threeStudentAnswerCnt++;
            else if ((i % 10 == 4 || i % 10 == 5) && answer == 2) threeStudentAnswerCnt++;
            else if ((i % 10 == 6 || i % 10 == 7) && answer == 4) threeStudentAnswerCnt++;
            else if ((i % 10 == 8 || i % 10 == 9) && answer == 5) threeStudentAnswerCnt++;
        }
        int maxAnswerCnt = Math.max(oneStudentAnswerCnt, Math.max(twoStudentAnswerCnt, threeStudentAnswerCnt));
        List<Integer> answerList = new ArrayList<>();
        if (maxAnswerCnt == oneStudentAnswerCnt) answerList.add(1);
        if (maxAnswerCnt == twoStudentAnswerCnt) answerList.add(2);
        if (maxAnswerCnt == threeStudentAnswerCnt) answerList.add(3);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}