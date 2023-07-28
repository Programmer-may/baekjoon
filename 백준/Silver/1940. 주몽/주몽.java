import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(i,num);
        }
        List<Integer> list = new ArrayList<Integer>(map.values());
        Collections.sort(list);
        int cnt = 0;
        
        for (int ri = list.size()-1 ; ri >= 0; ri--) {
            for (int li = 0; li < ri; li++){
                if (list.get(ri) + list.get(li) ==M){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}