import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int rows = board.length;
        int cols = board[0].length();


        int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = board[r].charAt(c);
                if (ch == 'R') {
                    startRow = r;
                    startCol = c;
                } else if (ch == 'G') {
                    endRow = r;
                    endCol = c;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int moves = current[2];

            if (r == endRow && c == endCol) {
                return moves;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r;
                int nc = c;
                while (true) {
                    int nextRow = nr + dr[i];
                    int nextCol = nc + dc[i];

                    if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || board[nextRow].charAt(nextCol) == 'D') {
                        break;
                    }
                    nr = nextRow;
                    nc = nextCol;
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, moves + 1});
                }
            }
        }
        return -1;
    }
}