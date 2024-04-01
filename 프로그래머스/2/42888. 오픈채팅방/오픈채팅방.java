import java.util.*;

class Solution {
    final String enter = "님이 들어왔습니다.";
    final String leave = "님이 나갔습니다.";
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        for (String info : record) {
            String[] userDetail = info.split(" ");
            if (userDetail[0].equals("Enter")) {
                map.put(userDetail[1], userDetail[2]);
                list.add(new String[]{userDetail[1], enter});
            } else if (userDetail[0].equals("Leave")) {
                list.add(new String[]{userDetail[1], leave});
            } else {
                map.put(userDetail[1], userDetail[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = map.get(list.get(i)[0]) + list.get(i)[1];
        }
        return answer;
    }
}