import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 각 번호 폰켓몬 마다 몇번 나왔는지 확인
        // 폰 켓몬을 최대한 여러가지 종류를 가질 수 있는 것을 확인
        int maxType = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxTypeOfPoncketmon = map.keySet().size();
        return Math.min(maxType, maxTypeOfPoncketmon);
    }
}