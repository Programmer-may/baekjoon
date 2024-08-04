import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        char[][] matrix = new char[N][M];
        boolean[][] isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = row[j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cs = cur[2];

            if (cr == N - 1 && cc == M - 1) {
                System.out.println(cs);
                return;
            }
            for (int j = 0; j < 4; j++) {
                int nr = cr + dr[j];
                int nc = cc + dc[j];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && matrix[nr][nc] == '1' && !isVisited[nr][nc]) {
                    queue.add(new int[]{nr, nc, cs + 1});
                    isVisited[nr][nc] = true;
                }
            }
        }
    }
}