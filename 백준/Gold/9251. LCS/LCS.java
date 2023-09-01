import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstString = br.readLine();
        String secondString = br.readLine();
        char[] firstStringArr = new char[firstString.length() + 1];
        char[] secondStringArr = new char[secondString.length() + 1];
        for (int i = 1; i <= firstString.length(); i++) {
            firstStringArr[i] = firstString.charAt(i - 1);
        }
        for (int i = 1; i <= secondString.length(); i++) {
            secondStringArr[i] = secondString.charAt(i - 1);
        }
        int[][] dp = new int[secondString.length() + 1][firstString.length() + 1];

        for (int i = 1; i <= secondString.length(); i++) {
            for (int y = 1; y <= firstString.length(); y++) {
                // 만일 두 문자가 같은 경우
                if (secondStringArr[i] == firstStringArr[y]) {
                    // 대각선의 값을 참고하여 LCS의 값을 + 1한다.
                    dp[i][y] = dp[i - 1][y - 1] + 1;
                }
                // 두 문자가 다른 경우
                else {
                    // 각 문자열의 이전 문자 중 최대 LCS값을 선택
                    dp[i][y] = Math.max(dp[i - 1][y], dp[i][y - 1]);
                }
            }
        }
        System.out.println(dp[secondString.length()][firstString.length()]);
    }
}