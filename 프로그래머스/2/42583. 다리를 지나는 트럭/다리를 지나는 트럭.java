import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();

        for(int i = 0 ; i<bridge_length ; i++) {
            bridge.offer(0);
        }
        for(int i : truck_weights) {
            trucks.offer(i);
        }

        int time = 0;
        int totalWeight = 0;
        while(!bridge.isEmpty())
        {
            totalWeight -= bridge.poll();

            if (trucks.isEmpty()) {
                time += bridge_length;
                break;
            } else {
                if ((totalWeight + trucks.peek()) <= weight) {
                        bridge.offer(trucks.peek());
                        totalWeight += trucks.peek();
                        trucks.poll();
                } else {
                    bridge.offer(0);
                }
            }
            time++;
        }
        return time;
    }
}