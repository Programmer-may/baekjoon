import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] info = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = info[j];
            }
        }
        int normalSection = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c]) {
                    normalSection++;
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int cr = now[0];
                        int cc = now[1];
                        char color = matrix[cr][cc];
                        for (int i = 0; i < 4; i++) {
                            int nr = cr + dr[i];
                            int nc = cc + dc[i];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n && color == matrix[nr][nc] && !visited[nr][nc]) {
                                queue.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }

        }
        visited = new boolean[n][n];
        int abnormalSection = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && (matrix[r][c] == 'G' || matrix[r][c] == 'R')) {
                    abnormalSection++;
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int cr = now[0];
                        int cc = now[1];
                        for (int i = 0; i < 4; i++) {
                            int nr = cr + dr[i];
                            int nc = cc + dc[i];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && ('R' == matrix[nr][nc] || 'G' == matrix[nr][nc])) {
                                queue.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                } else if (!visited[r][c] && matrix[r][c] == 'B') {
                    abnormalSection++;
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int cr = now[0];
                        int cc = now[1];
                        for (int i = 0; i < 4; i++) {
                            int nr = cr + dr[i];
                            int nc = cc + dc[i];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n && 'B' == matrix[nr][nc] && !visited[nr][nc]) {
                                queue.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(normalSection + " " + abnormalSection);
    }
}
