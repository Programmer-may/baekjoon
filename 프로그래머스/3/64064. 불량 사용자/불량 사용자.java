import java.util.*;

class Solution {
    Set<Set<String>> sets = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        String[] output = new String[banned_id.length];
        boolean[] visited = new boolean[user_id.length];
        int totalUserNum = user_id.length;
        int bannedUserNum = banned_id.length;
        perm(user_id, banned_id, output, visited, 0, totalUserNum, bannedUserNum);

        return sets.size();
    }
    void perm(String[] arr, String[] banned_id, String[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int tmp = 0;
            check : for (int i = 0; i < output.length; i++) {
                if (output[i].length() == banned_id[i].length()) {
                    for (int y = 0; y < output[i].length(); y++) {
                        if(output[i].charAt(y) != banned_id[i].charAt(y) && banned_id[i].charAt(y) != '*') break check;
                    }
                    tmp++;
                } else {
                    break;
                }
            }
            if (tmp == r) {
                Set<String> set = new HashSet<>();
                for (String id : output) {
                    set.add(id);
                }
                sets.add(set);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, banned_id, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}