import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertexNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());
        int[][] network = new int[vertexNum + 1][vertexNum + 1];

        for (int i = 0; i < edgeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            network[vertex1][vertex2] = 1;
            network[vertex2][vertex1] = 1;
        }
        br.close();

        int input = 1;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> infectedComputer = new HashSet<>();
        queue.add(input);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (!infectedComputer.contains(vertex)) {
                for (int i = 1; i <= vertexNum; i++) {
                    if (network[vertex][i] == 1) {
                        queue.add(i);
                    }
                }
            }
            infectedComputer.add(vertex);
        }
        System.out.println(infectedComputer.size() - input);
    }
}