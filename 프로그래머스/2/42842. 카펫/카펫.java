class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //브라운은 항상 노랑색 면의 모서리 갯수 + 4
        if (yellow != 1) {
            for (int verticalEdge = 1; verticalEdge <= yellow / 2; verticalEdge++) {
                if (yellow % verticalEdge == 0) {
                    int horizontalEdge = yellow / verticalEdge;
                    if (brown == (horizontalEdge + verticalEdge) * 2 + 4) {
                        answer[0] = horizontalEdge + 2;
                        answer[1] = verticalEdge + 2;
                        break;
                    }
                }
            }
        } else {
            answer[0] = yellow + 2;
            answer[1] = yellow + 2;
        }
        return answer;
    }
}