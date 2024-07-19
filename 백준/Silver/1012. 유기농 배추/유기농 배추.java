import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[][] field = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }
            
            int wormCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        bfs(field, visited, i, j, N, M);
                        wormCount++;
                    }
                }
            }
            sb.append(wormCount).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int[][] field, boolean[][] visited, int r, int c, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currR = current[0];
            int currC = current[1];
            
            for (int i = 0; i < 4; i++) {
                int newR = currR + dr[i];
                int newC = currC + dc[i];
                
                if (newR >= 0 && newR < N && newC >= 0 && newC < M && field[newR][newC] == 1 && !visited[newR][newC]) {
                    queue.add(new int[]{newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }
    }
}
