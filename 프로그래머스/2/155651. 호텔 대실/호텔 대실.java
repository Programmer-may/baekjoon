import java.util.*;

class Solution {
    class Book {
        int start;
        int end;
        Book(String[] info) {
            this.start = convertTime(info[0]);
            this.end = convertTime(info[1]) + 10;
        }
    }
    public int solution(String[][] book_time) {
        PriorityQueue<Book> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        PriorityQueue<Integer> endTimeList = new PriorityQueue<>();
        for (String[] arr : book_time) {
            pq.add(new Book(arr));
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            Book current = pq.poll();
            if (endTimeList.isEmpty()) {
                answer++;
                endTimeList.add(current.end);
            } else {
                int beforeBookEndTime = endTimeList.peek();
                if (beforeBookEndTime <= current.start) {
                    endTimeList.poll();
                    endTimeList.add(current.end);
                } else {
                    answer++;
                    endTimeList.add(current.end);
                }
            }
        }
        return answer;     
    }
    
    private int convertTime(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}