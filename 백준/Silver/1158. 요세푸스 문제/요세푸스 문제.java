import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<N;i++){
            list.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0; // 리스트의 첫 index는 0부터! 들어가는 숫자는 1들어가있음

        while(list.size() > 1) {
            index = (index + (K - 1)) % list.size();

            sb.append(list.remove(index)).append(", ");
        }

        sb.append(list.remove()).append(">");
        System.out.println(sb);
    }
}