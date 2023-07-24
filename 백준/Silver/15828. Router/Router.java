import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =  Integer.parseInt(br.readLine());
        Queue<Integer> router = new LinkedList<>();
        int info;
        while ( (info=Integer.parseInt(br.readLine())) != -1){
            if (router.size() !=N) {
                if (info != 0) {
                    router.add(info);
                } else {
                    router.poll();
                }
            } else {
                if (info == 0) {
                    router.poll();
                } else {
                    continue;
                }
            }
        }
        br.close();
        if (router.isEmpty()) {
            bw.write("empty");
        } else {
            for (int routerElement : router){
                bw.write(String.valueOf(routerElement) + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}