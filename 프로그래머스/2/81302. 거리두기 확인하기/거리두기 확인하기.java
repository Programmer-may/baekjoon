import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[] info = places[i];
            answer[i] = keepYourDistance(info);
        }
        return answer;
    }
    private int keepYourDistance(String[] info) {
        char[][] matrix = new char[5][5];
        boolean[][] isVisited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            char[] row = info[i].toCharArray();
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = row[j];
            }
        }
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (matrix[r][c] == 'P' && !isVisited[r][c]) {
                    Queue<int[]> queue = new LinkedList<>();
                    isVisited[r][c] = true;
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (canMove(nr, nc)) {
                            if (matrix[nr][nc] == 'P') return 0;
                            else if (matrix[nr][nc] == 'O') queue.add(new int[]{nr, nc});
                            while (!queue.isEmpty()) {
                                int[] now = queue.poll();
                                for (int k = 0; k < 4; k++) {
                                    int nnr = now[0] + dr[k];
                                    int nnc = now[1] + dc[k];
                                    if (canMove(nnr, nnc) && matrix[nnr][nnc] == 'P' && !isVisited[nnr][nnc]) return 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
    private boolean canMove(int nr, int nc) {
        return nr >= 0 && nr < 5 && nc >= 0 && nc < 5;
    }
}