class Solution {
    static long[] matrix = new long[100000 + 1];

    public static long solution(int n) {
        matrix[0] = 0;
        matrix[1] = 1;
        for (int i = 2; i <= 100000; i++) {
            matrix[i] = getFibonacciNum(i);
        }
        long fibonacciNum = matrix[n];
        return fibonacciNum % 1234567;
    }

    public static long getFibonacciNum(int num) {
        return (matrix[num - 1] + matrix[num - 2]) % 1234567;
    }
}