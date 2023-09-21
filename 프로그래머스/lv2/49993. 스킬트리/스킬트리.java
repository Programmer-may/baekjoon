import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int max = skill_trees.length;
        int impossibleST = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i];
            Queue<Character> queue = new LinkedList<>();
            for (char alp : skill.toCharArray()) {
                queue.add(alp);
            }
            for (char alp : str.toCharArray()) {
                if (queue.contains(alp)) {
                    if (queue.peek() == alp) {
                        queue.poll();
                    } else {
                        impossibleST++;
                        break;
                    }
                }
            }
        }
        return max - impossibleST;
    }
}