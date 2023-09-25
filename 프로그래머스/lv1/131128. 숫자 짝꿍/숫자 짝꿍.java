import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        int[] nums = new int[10];
        String[] xArr = X.split("");
        for (int i = 0; i < xArr.length; i++) {
            int alp = Integer.parseInt(xArr[i]);
            xMap.put(alp, xMap.getOrDefault(alp, 0) + 1);
        }
        String[] yArr = Y.split("");
        for (int i = 0; i < yArr.length; i++) {
            int alp = Integer.parseInt(yArr[i]);
            yMap.put(alp, yMap.getOrDefault(alp, 0) + 1);
            if (xMap.containsKey(alp)) {
                nums[alp] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (nums[i] == 1) {
                int cnt = Math.min(xMap.get(i), yMap.get(i));
                sb.append(String.valueOf(i).repeat(cnt));
            }
        }
        String str = sb.toString();
        if (str.length() == 0) {
            return "-1";
        } else if(str.replaceAll("0++","").length()==0){
            return "0";
        }
        return sb.toString();
    }
}