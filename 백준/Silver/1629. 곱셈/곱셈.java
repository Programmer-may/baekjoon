import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long A;
    private static long B;
    private static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        A = Integer.parseInt(info[0]);
        B = Integer.parseInt(info[1]);
        C = Integer.parseInt(info[2]);
        System.out.println(pow(A, B));
    }

    public static long pow(long A, long exponent) {

        if (exponent == 1) {
            return A % C;
        }

        long temp = pow(A, exponent / 2);

        if (exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }
}