class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        sum(numbers, numbers[0], 0, target);
        sum(numbers, -(numbers[0]), 0, target);

        return answer;
    }
    public void sum(int[] numbers, int num, int depth, int target) {
        if (depth == numbers.length - 1) {
            if (num == target) {
                answer++;
            }
            return;
        }
        sum(numbers, num + numbers[depth + 1], depth + 1, target);
        sum(numbers, num - numbers[depth + 1], depth + 1, target);
    }
}