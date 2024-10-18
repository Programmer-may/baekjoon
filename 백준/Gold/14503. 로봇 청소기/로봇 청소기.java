import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] info = br.readLine().split(" ");
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        int[][] matrix = new int[n][m];
        String[] robotInfo = br.readLine().split(" ");
        int curR = Integer.parseInt(robotInfo[0]);
        int curC = Integer.parseInt(robotInfo[1]);
        int direction = Integer.parseInt(robotInfo[2]);

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        boolean isDone = false;
        int answer = 0;
        while (!isDone) {
            if (matrix[curR][curC] == 0) {
                matrix[curR][curC] = 2;
                answer++;
            }
            if (matrix[curR + dr[0]][curC + dc[0]] != 0 && matrix[curR + dr[1]][curC + dc[1]] != 0 && matrix[curR + dr[2]][curC + dc[2]] != 0 && matrix[curR + dr[3]][curC + dc[3]] != 0) {
                int transDirection = direction + 2;
                if (transDirection >= 4) transDirection -= 4;
                int nextR = curR + dr[transDirection];
                int nextC = curC + dc[transDirection];
                if (matrix[nextR][nextC] == 1) {
                    isDone = true;
                } else {
                    curR = nextR;
                    curC = nextC;
                }
            } else {
                int transDirection = direction - 1;
                if (transDirection < 0) transDirection = 3;
                int nextR = curR + dr[transDirection];
                int nextC = curC + dc[transDirection];
                if (matrix[nextR][nextC] == 0) {
                    curR = nextR;
                    curC = nextC;
                }
                direction = transDirection;
            }
        }
        System.out.println(answer);
    }
}
