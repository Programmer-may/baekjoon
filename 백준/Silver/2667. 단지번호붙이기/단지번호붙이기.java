import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        char[][] matrix = new char[N][N];
        boolean[][] isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = row[j];
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (matrix[r][c] == '1' && !isVisited[r][c]) {
                    int tmp = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{r, c});
                    isVisited[r][c] = true;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        tmp++;
                        for (int i = 0; i < 4; i++) {
                            int nr = now[0] + dr[i];
                            int nc = now[1] + dc[i];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && matrix[nr][nc] == '1' && !isVisited[nr][nc]) {
                                queue.add(new int[]{nr, nc});
                                isVisited[nr][nc] = true;
                            }
                        }
                    }
                    answer.add(tmp);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (int num : answer) System.out.println(num);
    }
}