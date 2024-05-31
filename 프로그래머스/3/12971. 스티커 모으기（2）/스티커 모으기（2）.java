class Solution {
    public int solution(int sticker[]) {
        int size = sticker.length;
        if (size == 1) return sticker[0];
        else if (size == 2) return Math.max(sticker[0], sticker[1]);

        int[] dp1 = new int[size - 1];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        int[] dp2 = new int[size];
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < size; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}