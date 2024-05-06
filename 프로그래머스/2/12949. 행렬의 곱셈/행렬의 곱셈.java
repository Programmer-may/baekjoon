class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int c = 0; c < answer.length; c++) {
            for (int r = 0; r < answer[0].length; r++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[c][r] += arr1[c][k] * arr2[k][r];
                }
            }
        }
        return answer;
    }
}