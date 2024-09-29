import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int r, c, distance, hasWallBroken;

        Node(int r, int c, int distance, int hasWallBroken) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.hasWallBroken = hasWallBroken;
        }
    }

    static int n, m;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        isVisited = new boolean[n][m][2];
        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            if (currNode.r == n - 1 && currNode.c == m - 1) return currNode.distance;

            for (int i = 0; i < 4; i++) {
                int nr = currNode.r + dr[i];
                int nc = currNode.c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == 0 && !isVisited[nr][nc][currNode.hasWallBroken]) {
                    isVisited[nr][nc][currNode.hasWallBroken] = true;
                    queue.add(new Node(nr, nc, currNode.distance + 1, currNode.hasWallBroken));
                }

                if (map[nr][nc] == 1 && currNode.hasWallBroken == 0 && !isVisited[nr][nc][1]) {
                    isVisited[nr][nc][1] = true;
                    queue.add(new Node(nr, nc, currNode.distance + 1, 1));
                }
            }
        }
        return -1;
    }
}