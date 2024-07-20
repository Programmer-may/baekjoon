import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int y = Integer.parseInt(info[1]);
        int x = Integer.parseInt(info[0]);
        int[] dy = new int[]{-1, 0, 1, 0};
        int[] dx = new int[]{0, 1, 0, -1};
        int[][] matrix = new int[y][x];
        boolean[][] visited = new boolean[y][x];

        int totalTomato = 0;
        int totalMatured = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int j = 0; j < y; j++) {
            String[] row = br.readLine().split(" ");
            for (int l = 0; l < x; l++) {
                if (row[l].equals("1")) {
                    totalTomato++;
                    totalMatured++;
                    matrix[j][l] = 1;
                    queue.add(new int[]{j, l});
                    visited[j][l] = true;
                } else if (row[l].equals("0")) {
                    totalTomato++;
                    matrix[j][l] = 0;
                } else {
                    matrix[j][l] = -1;
                }
            }
        }
        if (totalMatured == 0) {
            System.out.println(-1);
            return;
        } else if (totalTomato == totalMatured) {
            System.out.println(0);
            return;
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int ny = now[0] + dy[k];
                    int nx = now[1] + dx[k];
                    if (ny >= 0 && ny < y && nx >= 0 && nx < x &&  matrix[ny][nx] != -1 && !visited[ny][nx]) {
                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        totalMatured++;
                    }
                }
            }
            answer++;
        }
        if (totalMatured != totalTomato) System.out.println(-1);
        else System.out.println(answer - 1);
    }
}
