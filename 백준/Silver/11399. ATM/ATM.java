import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            map.put(i,p);
        }
        List<Integer> list = new ArrayList<Integer>(map.values());
        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) * (list.size() - i);
        }
        System.out.println(sum);
    }
}