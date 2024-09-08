import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    int[] todayInfo = new int[3];
    
    class UserInfo {
        int order;
        int[] expirationDate = new int[3];
        
        UserInfo (String privacy, int order){
            String[] info = privacy.split(" ");
            int month = map.get(info[1]);
            String[] date = info[0].split("\\.");
            expirationDate[0] = Integer.parseInt(date[0]);
            int tmpMonth = Integer.parseInt(date[1]) + month;
            expirationDate[0] += (tmpMonth - 1) / 12;
            expirationDate[1] = (tmpMonth - 1) % 12 + 1;
            if (Integer.parseInt(date[2]) == 1) {
                expirationDate[1]--;
                if (expirationDate[1] == 0) {
                    expirationDate[0]--;
                    expirationDate[1] = 12;
                }
                expirationDate[2] = 28;
            } else expirationDate[2] = Integer.parseInt(date[2]) - 1;
            this.order = order;
        }
        
        private boolean isExpire() {
            if (expirationDate[0] < todayInfo[0]) return true;
            if (expirationDate[0] == todayInfo[0]) {
                if (expirationDate[1] < todayInfo[1]) return true;
                if (expirationDate[1] == todayInfo[1]) {
                    return expirationDate[2] < todayInfo[2];
                }
            }
            return false;
        }
        
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String term : terms) {
            String[] info = term.split(" ");
            map.put(info[0], Integer.parseInt(info[1]));
        }
        todayConvertInt(today);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            UserInfo info = new UserInfo(privacies[i] , i + 1);
            if (info.isExpire()) list.add(info.order);            
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private void todayConvertInt(String today) {
        String[] info = today.split("\\.");
        todayInfo[0] = Integer.parseInt(info[0]);
        todayInfo[1] = Integer.parseInt(info[1]);
        todayInfo[2] = Integer.parseInt(info[2]);
    }
}