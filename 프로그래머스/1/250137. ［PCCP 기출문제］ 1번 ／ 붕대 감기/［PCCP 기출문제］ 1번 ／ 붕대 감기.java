import java.util.*;

class Solution {
    Map<Integer, Integer> attackMap = new HashMap<>();
    public int solution(int[] bandage, int health, int[][] attacks) {
        int castingTime = bandage[0];
        int healPerSec = bandage[1];
        int additionalHeal = bandage[2];
        int maxTime = attacks[attacks.length - 1][0];
        for (int[] attack : attacks) {
            attackMap.put(attack[0], attack[1]);
            
        }
        int time = 1;
        int currentHealth = health;
        int continuousBandage = 0;
        while(time <= maxTime) {
            if (attackMap.containsKey(time)) {
                currentHealth -= attackMap.get(time);
                continuousBandage = 0;
            } else {
                currentHealth += healPerSec;
                continuousBandage++;
                if (continuousBandage == castingTime) {
                    currentHealth += additionalHeal;
                    continuousBandage = 0;
                }
                if (currentHealth >= health) currentHealth = health;
            }
            if (currentHealth < 0) return -1;
            time++;
        }
        return currentHealth == 0 ? -1 : currentHealth;
    }
}