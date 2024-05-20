import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new LinkedList<>();
        for (String command : operations) {
            if (command.charAt(0) == 'I') {
                list.add(Integer.parseInt(command.substring(2)));
                Collections.sort(list);
            } else if (command.equals("D 1") && list.size() != 0) {
                list.remove(list.size() - 1);
            } else if (command.equals("D -1") && list.size() != 0) {
                    list.remove(0);
            }
        }
        return list.size() == 0 ? new int[] {0, 0} : new int[]{list.get(list.size() - 1), list.get(0)};
    }
}