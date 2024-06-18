class Solution {
    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 400000000000000L; // 충분히 큰 값으로 초기화
        
        while (left < right) {
            long mid = (left + right) / 2;
            if (canDeliver(a, b, g, s, w, t, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    private static boolean canDeliver(int a, int b, int[] g, int[] s, int[] w, int[] t, long mid) {
        long totalGold = 0;
        long totalSilver = 0;
        long totalWeight = 0;

        for (int i = 0; i < g.length; i++) {

            long maxDeliveries = (mid - t[i]) / (2 * t[i]) + 1; // 첫 번째 편도 이후 왕복 횟수 계산
            long maxWeight = maxDeliveries * w[i]; // 해당 시간 내에 운반 가능한 최대 무게
            
            long goldDelivered = Math.min(g[i], maxWeight); // 운반 가능한 금
            long silverDelivered = Math.min(s[i], maxWeight); // 운반 가능한 은
            
            totalGold += goldDelivered;
            totalSilver += silverDelivered;
            totalWeight += Math.min(g[i] + s[i], maxWeight); // 총 운반 가능 무게
        }

        return totalGold >= a && totalSilver >= b && totalWeight >= a + b;
    }
}