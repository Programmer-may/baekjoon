import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students_clothes = new int[n+1];
        Arrays.fill(students_clothes,1);
        students_clothes[0] = 0;
        for(int studentNum : reserve){
            students_clothes[studentNum] += 1;
        }
        for(int studentNum : lost){
            students_clothes[studentNum] -= 1;
        }
        for(int studentNum = 1; studentNum < students_clothes.length; studentNum++){
            if(students_clothes[studentNum] == 0){
                if(students_clothes[studentNum - 1] >= 2){
                    students_clothes[studentNum - 1] -= 1;
                    students_clothes[studentNum] = 1;
                } else if(studentNum != (students_clothes.length - 1) && students_clothes[studentNum + 1] >= 2){
                    students_clothes[studentNum + 1] -= 1;
                    students_clothes[studentNum] = 1;
                }
            }
            if(students_clothes[studentNum] >= 1) answer++;
        }
        return answer;
    }
}