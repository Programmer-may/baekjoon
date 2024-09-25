
class Solution {
    int continousBandage = 0;
    int currentHeal;
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackIdx = 0;
        currentHeal = health;
        for (int time = 1; time <= attacks[attacks.length - 1][0]; time++) {
            if (time == attacks[attackIdx][0]){
                currentHeal -= attacks[attackIdx][1];
                continousBandage = 0;
                attackIdx++;
            } else {
                currentHeal = heal(bandage, health);
            }
            if (currentHeal <= 0) return -1;
        }
        return currentHeal == 0 ? -1 : currentHeal;
    }
    
    private int heal(int[] bandage, int health) {
        currentHeal += bandage[1];
        continousBandage++;
        if (continousBandage == bandage[0]) {
            currentHeal += bandage[2];
            continousBandage = 0;
        }
        if (currentHeal >= health) return health;
        return currentHeal;
    }
}