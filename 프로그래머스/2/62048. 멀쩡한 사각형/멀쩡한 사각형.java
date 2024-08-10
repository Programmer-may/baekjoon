class Solution {
    public long solution(long w, long h) {
        long useless = 0;
        long totalSquare = w * h;
        long y = 0;
        long tmp = 0;
        for (int i = 1; i <= w; i++) {
            tmp = h * i / w;
            useless += tmp - y;
            y = tmp;
            if (h * i % w != 0) useless++;
        }
        return totalSquare - useless;
    }
}