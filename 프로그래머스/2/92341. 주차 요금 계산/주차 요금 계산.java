import java.util.*;

class Solution {
    int defaultMin, defaultFee, unitTime, unitFee;
    Map<String, int[]> record = new HashMap<>();
    TreeSet<String> hasBeen = new TreeSet<>();
    public int[] solution(int[] fees, String[] records) {
        init(fees);
        for (String carRecord : records) {
            String[] info = carRecord.split(" ");
            if (info[2].equals("IN")) {
                record.putIfAbsent(info[1], new int[3]);
                record.get(info[1])[0] = calculateTime(info[0]);
                hasBeen.add(info[1]);
            } else {
                record.get(info[1])[1] = calculateTime(info[0]);
                record.get(info[1])[2] += record.get(info[1])[1] - record.get(info[1])[0];
            }
        }
        int[] answer = new int[hasBeen.size()];
        for (int i = 0; i < answer.length; i++) {
            String carNum = hasBeen.pollFirst();
            int[] carRecord = record.get(carNum);
            int entranceTime = carRecord[0];
            int exitTime = carRecord[1];
            int parkingTime = carRecord[2];
            if (entranceTime > exitTime || exitTime == 0) {
                parkingTime += calculateTime("23:59") - entranceTime;
            }
            int totalFee = defaultFee;
            if (parkingTime > defaultMin) {
                int diffTime = Math.abs(defaultMin - parkingTime);
                totalFee += ((diffTime + unitTime - 1) / unitTime) * unitFee;
            }
            answer[i] = totalFee;
        }
        return answer;
    }
    private void init(int[] fees) {
        defaultMin = fees[0];
        defaultFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
    }
    private int calculateTime (String info) {
        String[] time = info.split(":");
        return (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
    }
}