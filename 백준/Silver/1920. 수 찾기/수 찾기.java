import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =  Integer.parseInt(br.readLine());
        Set<Integer> inputSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            inputSet.add(n);
        }
        int M =  Integer.parseInt(br.readLine());
        StringTokenizer testST = new StringTokenizer(br.readLine());
        for(int i=0; i<M;i++){
            int n = Integer.parseInt(testST.nextToken());
            if(inputSet.contains(n)){
                bw.write((String.valueOf(1)+"\n"));
            }else {
                bw.write((String.valueOf(0)+"\n"));
            }
        }
        bw.flush();
        bw.close();
    }
}