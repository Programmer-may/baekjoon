import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int vertexNum = Integer.parseInt(st.nextToken());
        int indegreeNum = Integer.parseInt(st.nextToken());
        int[] in = new int[vertexNum + 1];
        int[] result = new int[vertexNum + 1];
        int[][] graph = new int[vertexNum + 1][vertexNum + 1];

        for (int i = 0; i < indegreeNum; i++) {
            StringTokenizer stPrerequisite = new StringTokenizer(br.readLine(), " ");
            int prerequisite = Integer.parseInt(stPrerequisite.nextToken());
            int subSubject = Integer.parseInt(stPrerequisite.nextToken());
            graph[prerequisite][subSubject] = 1;
            in[subSubject]++;
        }

        Queue<Integer> queue = new LinkedList<>();


        for (int i = 1; i <= vertexNum; i++) {
            int cnt = 0;
            for (int j = 1; j <= vertexNum; j++) {
                if (graph[j][i] == 0) {
                    cnt++;
                }
                if (cnt == vertexNum) {
                    queue.add(i);

                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        int pre = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int x =0; x<queueSize;x++){
                int nowVertex = queue.poll();
                result[nowVertex] = pre;
                for (int y = nowVertex + 1; y <= vertexNum; y++) {
                    if (graph[nowVertex][y]==1) {
                        in[y]--;
                        if (in[y] == 0)
                            queue.add(y);
                    }
                }
            }
            pre++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < vertexNum; i++) {
            sb.append(result[i] + " ");
        }
        sb.append(result[vertexNum]);
        System.out.println(sb);
    }
}