import java.util.*;

class Solution {
    class Process {
        int startTime;
        int taskTime;
        Process(int startTime, int taskTime) {
            this.startTime = startTime;
            this.taskTime = taskTime;
        }
    }
    public int solution(int[][] jobs) {
         // 작업을 요청 시간 순서로 정렬하는 힙
        PriorityQueue<Process> startMinHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.startTime));
        // 작업 소요 시간 순서로 정렬하는 힙
        PriorityQueue<Process> taskMinHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.taskTime));
    
        // 모든 작업을 startMinHeap에 추가
        for (int[] job : jobs) {
            startMinHeap.add(new Process(job[0], job[1]));
        }
        int totalProcess = jobs.length;
        int currentTime = 0;
        int totalWaitTime = 0;
        int jobsProcessed = 0;

        while (jobsProcessed < totalProcess) {
            // 현재 시간에 수행할 수 있는 모든 작업을 taskMinHeap에 추가
            while (!startMinHeap.isEmpty() && startMinHeap.peek().startTime <= currentTime) {
                taskMinHeap.add(startMinHeap.poll());
            }

            // 수행할 작업이 있다면
            if (!taskMinHeap.isEmpty()) {
                Process currentProcess = taskMinHeap.poll();
                currentTime += currentProcess.taskTime;
                totalWaitTime += currentTime - currentProcess.startTime;
                jobsProcessed++;
            } else {
                // 수행할 작업이 없다면, 다음 작업의 요청 시점으로 이동
                currentTime = startMinHeap.peek().startTime;
            }
        }

        return totalWaitTime / totalProcess;
    }
}