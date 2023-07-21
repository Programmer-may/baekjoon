import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int n = Integer.parseInt(st.nextToken());
        //1~n 까지 숫자가 있다.

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while(queue.size()>1){
            queue.poll();
            int next = queue.peek();
            queue.add(next);
            queue.poll();
        }
        System.out.println(queue.peek());
    }
}