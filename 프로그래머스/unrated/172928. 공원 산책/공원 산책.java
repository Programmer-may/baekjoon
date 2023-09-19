import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] parkMatrix = new char[park.length][park[0].length()];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        char[] dir = {'N', 'E', 'S', 'W'};
        int startR = 0;
        int startC = 0;
        int horizonMax = park[0].length() - 1;
        int verticalMax = park.length - 1;
        for (int i = 0; i < park.length; i++) {
            String[] val = park[i].split("");
            for (int j = 0; j < val.length; j++) {
                parkMatrix[i][j] = val[j].charAt(0);
                if (val[j].charAt(0) == 'S') {
                    startR = i;
                    startC = j;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            char cmd = routes[i].split(" ")[0].charAt(0);
            int distance = Integer.parseInt(routes[i].split(" ")[1]);
            for (int k = 0; k < 4; k++) {
                if (cmd == dir[k]) {
                    int nc = startC;
                    int nr = startR;
                    int tmp = 0;
                    for (int t = 0; t < distance; t++) {
                        nr = nr + dr[k];
                        nc = nc + dc[k];
                        if (nr < 0 || nr > verticalMax || nc < 0 || nc > horizonMax || parkMatrix[nr][nc] == 'X')
                            continue;
                        tmp++;
                    }
                    if (tmp == distance) {
                        startR = nr;
                        startC = nc;
                    }
                }
            }
        }
        return new int[]{startR, startC};
    }
}