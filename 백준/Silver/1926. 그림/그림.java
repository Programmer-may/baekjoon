import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int y = 0; y < m; y++) {
                if (row[y].equals("1")) matrix[i][y] = 1;
            }

        }
        Deque<int[]> stack = new ArrayDeque<>();
        int mostLargest = 0;
        int paintingNum = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int[] now = new int[]{r, c};
                int areaTmp = 0;
                if (matrix[r][c] == 1 && !visited[r][c]) {
                    paintingNum++;
                    visited[r][c] = true;
                    stack.push(now);
                    while (!stack.isEmpty()) {
                        int[] curr = stack.poll();
                        areaTmp++;
                        for (int i = 0; i < 4; i++) {
                            int nr = curr[0] + dr[i];
                            int nc = curr[1] + dc[i];
                            int[] next = new int[]{nr, nc};
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] == 1 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                stack.push(next);
                            }
                        }
                    }
                    mostLargest = Math.max(mostLargest, areaTmp);
                }
            }
        }
        System.out.println(paintingNum);
        System.out.println(mostLargest);
    }
}
