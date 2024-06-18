import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        if (rocks.length == n) return distance;
        Arrays.sort(rocks);

        int[] diff = new int[rocks.length+1];
        diff[0] = rocks[0];
        diff[diff.length - 1] = distance - rocks[rocks.length - 1];
        for(int i = 1; i < rocks.length; i++){
            diff[i] = rocks[i] - rocks[i - 1];
        }

        int left = 0;
        int right = distance;
        while(left < right){

            int mid = (left + right) / 2;
            int removedStone = 0;
            int tmp = 0;
            for(int i = 0; i < diff.length; i++){

                tmp += diff[i];
                if(tmp < mid){
                    removedStone++;
                } else {
                    tmp = 0;
                }
            }

            if(removedStone < n){
                left = mid + 1;
            } else if(removedStone > n){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}