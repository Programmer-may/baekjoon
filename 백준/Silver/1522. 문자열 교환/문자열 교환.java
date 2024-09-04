import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        // 1. 'a'의 개수를 구함
        int aCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        // 만약 'a'의 개수가 0이거나 모두 'a'라면 교환할 필요가 없음
        if (n <= 2 || aCount == 0 || aCount == n) {
            System.out.println(0);
            return;
        }

        // 2. 두 번 이어붙인 문자열을 생성
        String doubled = s + s;

        // 3. 슬라이딩 윈도우를 통해 'a'의 개수만큼의 구간에서 'b'의 최소 개수를 구함
        int bCount = 0;

        // 처음 윈도우 설정
        for (int i = 0; i < aCount; i++) {
            if (doubled.charAt(i) == 'b') {
                bCount++;
            }
        }
        int minSwaps = bCount;

        // 슬라이딩 윈도우 진행
        for (int i = 1; i < n; i++) {
            // 윈도우에서 이전 첫 문자를 빼고
            if (doubled.charAt(i - 1) == 'b') {
                bCount--;
            }
            // 새로운 끝 문자를 추가
            if (doubled.charAt(i + aCount - 1) == 'b') {
                bCount++;
            }
            // 최소 교환 횟수 갱신
            minSwaps = Math.min(minSwaps, bCount);
        }

        // 4. 결과 출력
        System.out.println(minSwaps);
    }
}