import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer =0;

        Stack<Integer> stack = new Stack<>();
        for (int i =0; i<N ;i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        for (int i =0; i<N ;i++) {
            int num = stack.pop();
            if (K/num > 0){
                answer += K/num;
                K = K - ((K/num) * num);
            }
        }
        System.out.println(answer);
    }
}