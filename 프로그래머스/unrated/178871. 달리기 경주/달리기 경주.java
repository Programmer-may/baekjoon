import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        HashMap<Integer, String> rankMap = new HashMap<>();
        int rank = 0;
        for (String player : players) {
            rank++;
            playerMap.put(player, rank);
            rankMap.put(rank, player);
        }
        for (int i = 0; i < callings.length; i++) {
            int playerCurrRank = playerMap.get(callings[i]);
            String frontPlayer = rankMap.get(playerCurrRank - 1);
            playerMap.replace(callings[i], playerCurrRank - 1);
            playerMap.replace(frontPlayer, playerCurrRank);
            rankMap.replace(playerCurrRank - 1, callings[i]);
            rankMap.replace(playerCurrRank, frontPlayer);
        }
        String[] answer = new String[players.length];
        for (String player : players) {
            answer[playerMap.get(player) - 1] = player;
        }
        return answer;
    }
}