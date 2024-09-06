import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }
        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            String[] info = br.readLine().split(" ");
            if (info[0].equals("1")) {
                boyProcess(Integer.parseInt(info[1]));
            } else {
                girlProcess(Integer.parseInt(info[1]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void boyProcess(int num) {
        for (int i = 1; i <= (arr.length - 1) / num; i++) {
            if (arr[i * num] == 0) {
                arr[i * num] = 1;
            } else {
                arr[i * num] = 0;
            }
        }
    }
    private static void girlProcess(int num) {
        int length = Math.min(num - 1, arr.length - 1 - num);
        if (arr[num] == 0) {
            arr[num] = 1;
        } else {
            arr[num] = 0;
        }
        for (int i = 1; i <= length; i++) {
            if (arr[num - i] == arr[num + i]) {
                if (arr[num - i] == 0) {
                    arr[num - i] = 1;
                } else {
                    arr[num - i] = 0;
                }
                if (arr[num + i] == 0) {
                    arr[num + i] = 1;
                } else {
                    arr[num + i] = 0;
                }
            } else {
                break;
            }
        }
    }
}