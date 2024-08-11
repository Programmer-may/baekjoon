import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < timetable.length; i++) {
            order.add(calcurateTime(timetable[i]));
        }
        Collections.sort(order);
        
        int startTime = 540;
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            int shuttleTime = startTime + i * t;
            int count = 0;
            
            while (count < m && idx < order.size() && order.get(idx) <= shuttleTime) {
                count++;
                idx++;
            }
            
            if (i == n - 1) {
                if (count < m) { 
                    return proceedAnswer(shuttleTime);
                } else {
                    return proceedAnswer(order.get(idx - 1) - 1);
                }
            }
        }
        return null;
    }
    
    private int calcurateTime(String info) {
        String[] time = info.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    private String proceedAnswer(int time) {
        StringBuilder sb = new StringBuilder();
        int hour = time / 60;
        int min = time % 60;
        if (hour < 10) sb.append(0).append(hour);
        else sb.append(hour);
        sb.append(":");
        if (min < 10) sb.append(0).append(min);
        else sb.append(min);
        return sb.toString();
    }
}