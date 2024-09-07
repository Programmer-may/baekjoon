import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] video = new int[4];
        video[0] = calculateTime(video_len);
        video[1] = calculateTime(pos);
        video[2] = calculateTime(op_start);
        video[3] = calculateTime(op_end);
        if (isOpening(video)) video[1] = video[3];
        for (String command : commands) {
            if (command.equals("prev")) {
                if (video[1] <= 10) video[1] = 0;
                else video[1] -= 10;
            } else {
                if (video[1] + 10 >= video[0]) video[1] = video[0];
                else video[1] += 10;
            }
            if (isOpening(video)) video[1] = video[3];
        }
        
        return proceedAnswer(video[1]);
    }
    private int calculateTime(String time) {
        String[] timeInfo = time.split(":");
        return Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
    }
    
    private String proceedAnswer(int time) {
        StringBuilder sb = new StringBuilder();
        int hour = time / 60;
        int min = time % 60;
        if (hour < 10) sb.append("0");
        sb.append(hour).append(":");
        if (min < 10) sb.append("0");
        sb.append(min);
        return sb.toString();
    }
    
    private boolean isOpening(int[] video) {
        return video[2] <= video[1] && video[1] <= video[3];
    }
}