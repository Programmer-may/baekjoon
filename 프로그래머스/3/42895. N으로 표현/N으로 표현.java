import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        // DP 배열을 초기화
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // 초기 값을 설정
        dp.get(1).add(N);

        for (int i = 2; i <= 8; i++) {
            Set<Integer> currentSet = dp.get(i);
            // N, NN, NNN, NNNN 등과 같은 값을 추가
            int repeatedNumber = Integer.parseInt(String.valueOf(N).repeat(i));
            currentSet.add(repeatedNumber);

            // j번 사용한 결과와 (i-j)번 사용한 결과를 조합
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);
                for (int num1 : set1) {
                    for (int num2 : set2) {
                        currentSet.add(num1 + num2);
                        currentSet.add(num1 - num2);
                        currentSet.add(num1 * num2);
                        if (num2 != 0) {
                            currentSet.add(num1 / num2);
                        }
                    }
                }
            }

            // 목표 숫자를 찾으면 현재 i를 반환
            if (currentSet.contains(number)) {
                return i;
            }
        }

        return -1;
    }
}