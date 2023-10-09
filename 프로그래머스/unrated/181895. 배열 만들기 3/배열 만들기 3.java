class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int totalSize = 0;
        for(int[] interval : intervals){
            totalSize += interval[1] - interval[0] + 1;
        }
        int[] answer = new int[totalSize];
        int idx = 0;
        for(int i =0; i < intervals.length; i++){
            int[] interval = intervals[i];
            for(int j = interval[0]; j <= interval[1]; j++){
                answer[idx++] = arr[j];
            }
        }
        return answer;
    }
}