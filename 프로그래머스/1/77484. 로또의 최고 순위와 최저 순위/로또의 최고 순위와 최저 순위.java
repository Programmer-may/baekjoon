import java.util.*;

class Solution {
    Map<Integer, Integer> score = new HashMap<>();
    public int[] solution(int[] lottos, int[] win_nums) {
        init();
        Set<Integer> nums = new HashSet<>();
        for (int num : win_nums) {
             nums.add(num);
        }
        int lowGoul = 0;
        int highGoal = 0;
        for (int num : lottos) {
            if (num == 0) highGoal++;
            else {
                if(nums.contains(num)) {
                    lowGoul++;
                    highGoal++;
                } 
            }
        }
        return new int[]{score.get(highGoal), score.get(lowGoul)} ;
    }
    private void init() {
        score.put(6, 1);
        score.put(5, 2);
        score.put(4, 3);
        score.put(3, 4);
        score.put(2, 5);
        score.put(1, 6);
        score.put(0, 6);
    }
}