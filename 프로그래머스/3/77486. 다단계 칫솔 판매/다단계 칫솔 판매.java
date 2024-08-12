import java.util.*;

class Solution {
     class Info {
        String recommender;
        int money = 0;
        
        Info(String recommender) {
            this.recommender = recommender;
        }
        void addMoney(int money) {
            this.money += money;
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Info> map = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], new Info(referral[i]));
        }
        
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int earnings = amount[i] * 100;
            
            while (!sellerName.equals("-")) {
                Info info = map.get(sellerName);
                int commission = earnings / 10;
                info.addMoney(earnings - commission);
                
                sellerName = info.recommender;
                earnings = commission;
                
                if (earnings < 1) {
                    break;
                }
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).money;
        }
        
        return answer;
    }
}