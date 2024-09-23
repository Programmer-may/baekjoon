import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private static final int receivedMoney = 1000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int change = receivedMoney - n;
        List<Integer> list = List.of(500, 100, 50, 10, 5, 1);
        int answer = 0;
        for (int unit : list) {
            if (change >= unit) {
                answer += change / unit;
                change -= (change / unit) * unit;
            }
        }
        System.out.println(answer);
    }
}