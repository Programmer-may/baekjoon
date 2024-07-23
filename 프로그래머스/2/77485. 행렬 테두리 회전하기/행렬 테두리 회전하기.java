class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {       
        int[][] matrix = new int[rows + 1][columns + 1];
        for(int r = 1; r <= rows; r++) {
            for(int c = 1; c <= columns; c++) {
                matrix[r][c] = (r - 1) * columns + c;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int startR = query[0];
            int startC = query[1];
            int endR = query[2];
            int endC = query[3];
            int before = matrix[startR + 1][startC];
            int tmpAnswer = matrix[startR + 1][startC];
            for (int c = startC; c < endC; c++) {
                int now = matrix[startR][c];
                matrix[startR][c] = before;
                before = now;
                tmpAnswer = Math.min(tmpAnswer, now);
            }
            for (int r = startR; r < endR; r++) {
                int now = matrix[r][endC];
                matrix[r][endC] = before;
                before = now;
                tmpAnswer = Math.min(tmpAnswer, now);              
            }
            for (int c = endC; c > startC; c--) {
                int now = matrix[endR][c];
                matrix[endR][c] = before;
                before = now;
                tmpAnswer = Math.min(tmpAnswer, now);
                
            }
            for (int r = endR; r > startR; r--) {
                int now = matrix[r][startC];
                matrix[r][startC] = before;
                before = now;
                tmpAnswer = Math.min(tmpAnswer, now);
            }
            answer[i] = tmpAnswer;
        }
        
        return answer;
    }
}