import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int leftIdx = 0;
        int rightIdx = people.length-1;
        int answer = 0;
        while(leftIdx <= rightIdx) {
            if(people[leftIdx] + people[rightIdx] <= limit) {
                leftIdx++;
            }
            rightIdx--;
            answer++;
        }
        return answer;
    }
}