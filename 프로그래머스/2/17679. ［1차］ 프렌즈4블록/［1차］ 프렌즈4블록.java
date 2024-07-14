import java.util.*;

class Solution {
    int[] dr = new int[]{0, 0, 1, 1};
    int[] dc = new int[]{0, 1, 0, 1};
    
    public int solution(int m, int n, String[] board) {
        char[][] matrix = new char[m][n];
        for (int r = 0; r < m; r++) {
            char[] arr = board[r].toCharArray();
            for (int c = 0; c < n; c++) {
                matrix[r][c] = arr[c];
            }
        }
        
        int answer = 0;
        boolean isDone = false;
        
        while (!isDone) {
            List<int[]> pang = new ArrayList<>();
            for (int r = 0; r < m - 1; r++) {
                for (int c = 0; c < n - 1; c++) {
                    if (matrix[r][c] == '.') continue;
                    char curr = matrix[r][c];
                    if (curr == matrix[r + 1][c] && curr == matrix[r][c + 1] && curr == matrix[r + 1][c + 1]) {
                        pang.add(new int[]{r, c});
                    }
                }
            }
            
            if (!pang.isEmpty()) {
                Set<String> isVisited = new HashSet<>();
                for (int[] block : pang) {
                    int r = block[0];
                    int c = block[1];
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        isVisited.add(nr + "," + nc);
                        matrix[nr][nc] = '.';
                    }
                }
                
                answer += isVisited.size();
                
                for (int c = 0; c < n; c++) {
                    List<Character> column = new ArrayList<>();
                    for (int r = m - 1; r >= 0; r--) {
                        if (matrix[r][c] != '.') column.add(matrix[r][c]);
                    }
                    int idx = 0;
                    for (int r = m - 1; r >= 0; r--) {
                        if (idx < column.size()) {
                            matrix[r][c] = column.get(idx++);
                        } else {
                            matrix[r][c] = '.';
                        }
                    }
                }
            } else {
                isDone = true;
            }
        }
        
        return answer;
    }
}
