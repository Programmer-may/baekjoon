import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        for(int i =0;i<N;i++){
            String[] line = br.readLine().split(" ");
            map.put(line[0],line[1]);
        }
        for(int i =0;i<M;i++){
            String[] line = br.readLine().split(" ");
            if(map.containsKey(line[0])){
                bw.write(map.get(line[0])+"\n");
            }else {
                bw.write("There is no password!");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}