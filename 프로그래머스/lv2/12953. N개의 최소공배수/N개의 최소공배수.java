import java.math.BigInteger;

class Solution {
    public int solution(int[] arr) {
        BigInteger a = new BigInteger(String.valueOf(arr[0]));

        for (int i = 1; i < arr.length; i++) {
            BigInteger b = new BigInteger(String.valueOf(arr[i]));
            a = a.multiply(b).divide(a.gcd(b));
        }
        return a.intValue();
    }
}