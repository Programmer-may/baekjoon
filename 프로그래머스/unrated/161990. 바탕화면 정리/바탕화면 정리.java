import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[][] matrix = new int[wallpaper.length][wallpaper[0].length()];
        int cnt = 0;
        for (int r = 0; r < wallpaper.length; r++) {
            String[] str = wallpaper[r].split("");
            for (int c = 0; c < wallpaper[0].length(); c++) {
                if (str[c].equals("#")) {
                    matrix[r][c] = 1;
                    cnt++;
                }
            }
        }
        int[] xArr = new int[cnt * 2];
        int[] yArr = new int[cnt * 2];
        int idx = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 1) {
                    xArr[idx] = c;
                    yArr[idx] = r;
                    xArr[idx + 1] = c + 1;
                    yArr[idx + 1] = r + 1;
                    idx += 2;
                }
            }
        }
        return new int[]{
                Arrays.stream(yArr).min().getAsInt(),
                Arrays.stream(xArr).min().getAsInt(),
                Arrays.stream(yArr).max().getAsInt(),
                Arrays.stream(xArr).max().getAsInt()};
    }
}