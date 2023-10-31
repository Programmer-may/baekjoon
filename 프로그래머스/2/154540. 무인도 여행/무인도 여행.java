import java.util.*;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int score = 0;

    public int[] solution(String[] maps) {
        char[][] board = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            board[i] = maps[i].toCharArray();
        }
        ArrayList<Integer> scoreList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'X') {
                    score = 0;
                    DFS(i, j, board); // Flood fill 발생
                    scoreList.add(score);
                }
            }
        }
        scoreList.sort((a, b) -> a - b);
        int[] answer = new int[scoreList.size()];
        for(int i = 0; i < scoreList.size(); i++) answer[i] = scoreList.get(i);
        return scoreList.size() == 0 ? new int[]{-1} : answer;
    }

    public void DFS(int x, int y, char[][] board) {
        score += (board[x][y] - 48);
        board[x][y] = 'X';
        for (int k = 0; k < 4; k++) {
            int nx = x + dr[k];
            int ny = y + dc[k];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] != 'X') {
                DFS(nx, ny, board);
            }
        }
    }
}