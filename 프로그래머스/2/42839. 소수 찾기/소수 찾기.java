import java.util.*;

class Solution {
    char[] check = new char[7];
    StringBuilder sb = new StringBuilder();
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        char[] numArr = numbers.toCharArray();
        for (int i = 1; i <= numbers.length(); i++) {
            dfs(0, i, numArr);
        }
        return answer;
    }

    void dfs(int lev, int i, char[] numArr) {
        if (lev == i) {
            int num = Integer.parseInt(sb.toString());
            if (isPrimeNumber(num) && !set.contains(num)) {
                set.add(num);
                answer++;
            }
        } else {
            for (int j = 0; j < numArr.length; j++) {
                if (check[j] == 0) {
                    check[j] = 1;
                    sb.append(numArr[j]);
                    dfs(lev + 1, i, numArr);
                    check[j] = 0;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
    boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return number != 0 && number != 1;
    }
}