class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int tmpA = arr[a];
            int tmpB = arr[b];
            arr[a] = tmpB;
            arr[b] = tmpA;
        }
        return arr;
    }
}