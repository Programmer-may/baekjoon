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
        int[][] matrix = new int[N][M];
        int[][] answer = new int[N][M];
        for (int[] arr : answer) {
            Arrays.fill(arr, -1);
        }
        boolean[][] isVisited = new boolean[N][M];
        int startR = 0;
        int startC = 0;
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                if (row[j].equals("2")) {
                    startR = i;
                    startC = j;
                } else if (row[j].equals("0")) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    answer[i][j] = Integer.parseInt(row[j]);
                } else {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        isVisited[startR][startC] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int cr = cur[0];
                int cc = cur[1];
                answer[cr][cc] = step;
                for (int j = 0; j < 4; j++) {
                    int nr = cr + dr[j];
                    int nc = cc + dc[j];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && matrix[nr][nc] != 0 && !isVisited[nr][nc]) {
                        queue.add(new int[]{nr, nc});
                        isVisited[nr][nc] = true;
                    }
                }
            }
            step++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}