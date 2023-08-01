class Solution {
    public int solution(int[] scoville, int K) {
        
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        
        if (pq.peek()>=K) {
            return answer;
        } else {
            while (pq.peek() < K && pq.size() != 1) {
                int min = pq.poll();
                int nextMin = pq.poll();
                pq.add(min+(nextMin*2));
                answer++;
            }
            if (pq.peek()<K){
                return -1;
            } else {
                return answer;
            }
            
        }
    }   
}