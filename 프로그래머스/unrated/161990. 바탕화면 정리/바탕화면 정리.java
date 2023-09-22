import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        for (int r = 0; r < wallpaper.length; r++) {
            for (int c = 0; c < wallpaper[r].length(); c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    if (xMax < c) xMax = c;
                    if (xMin > c) xMin = c;
                    if (yMax < r) yMax = r;
                    if (yMin > r) yMin = r;
                }
            }
        }
        return new int[]{yMin , xMin ,yMax+1,xMax+1};
    }
}