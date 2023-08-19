import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] phone_number = new String[N]; // 전화번호 목록.
 
            for (int i = 0; i < N; i++) {
                phone_number[i] = br.readLine();
            }
            Arrays.sort(phone_number); // 오름차순으로 정렬.
 
            if (isConsistent(N, phone_number)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
 
    // 전화번호 목록이 일관성이 있는지 검사.
    public static boolean isConsistent(int N, String[] phone_number) {
        // 현재 배열은 오름차순 정렬이 되어있는 상태.
        // 만약 전화 번호 목록 안에 접두어 관계가 있는 문자열이 있다면,
        // 특정 문자열 바로 뒤에 접두어 관계가 있는 문자열이 있을 것이다.
        // 결과적으로, 전화번호 목록이 일관성이 있는지 검사하려면
        // 특정 문자열과 그 다음 문자열의 접두어 관계만 확인하면 된다.
        for (int i = 0; i < N - 1; i++) {
            if (phone_number[i + 1].startsWith(phone_number[i])) {
                return false;
            }
        }

        return true;
    }
 
}