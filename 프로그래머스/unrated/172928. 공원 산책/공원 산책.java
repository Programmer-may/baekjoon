import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        String[][] parkMatrix = new String[park.length][park[0].length()];
        int x = 0;
        int y = 0;
        int horizonMin = 0;
        int verticalMin = 0;
        int horizonMax = park[0].length() - 1;
        int verticalMax = park.length - 1;
        for (int i = 0; i < park.length; i++) {
            String[] val = park[i].split("");
            for (int j = 0; j < val.length; j++) {
                parkMatrix[i][j] = val[j];
                if (val[j].equals("S")) {
                    x = j;
                    y = i;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String[] val = routes[i].split(" ");
            String direction = val[0];
            if (direction.equals("E")) {
                int cnt = 0;
                int tmp = x;
                for (int r = 0; r < Integer.parseInt(val[1]); r++) {
                    if (tmp + 1 <= horizonMax && !parkMatrix[y][tmp + 1].equals("X")) {
                        cnt++;
                        tmp++;
                    }
                }
                if (cnt == Integer.parseInt(val[1])) {
                    x += Integer.parseInt(val[1]);
                }

            } else if (direction.equals("W")) {
                int cnt = 0;
                int tmp = x;
                for (int r = 0; r < Integer.parseInt(val[1]); r++) {
                    if (tmp - 1 >= horizonMin && !parkMatrix[y][tmp - 1].equals("X")) {
                        cnt++;
                        tmp--;
                    }
                }
                if (cnt == Integer.parseInt(val[1])) {
                    x -= Integer.parseInt(val[1]);
                }

            } else if (direction.equals("S")) {
                int cnt = 0;
                int tmp = y;
                for (int r = 0; r < Integer.parseInt(val[1]); r++) {
                    if (tmp + 1 <= verticalMax && !parkMatrix[tmp + 1][x].equals("X")) {
                        cnt++;
                        tmp++;
                    }
                }
                if (cnt == Integer.parseInt(val[1])) {
                    y += Integer.parseInt(val[1]);
                }

            } else if (direction.equals("N")) {
                int cnt = 0;
                int tmp = y;
                for (int r = 0; r < Integer.parseInt(val[1]); r++) {
                    if (tmp - 1 >= verticalMin && !parkMatrix[tmp - 1][x].equals("X")) {
                        cnt++;
                        tmp--;
                    }
                }
                if (cnt == Integer.parseInt(val[1])) {
                    y -= Integer.parseInt(val[1]);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = y;
        answer[1] = x;
        return answer;
    }
}