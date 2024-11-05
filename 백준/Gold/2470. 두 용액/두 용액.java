import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(nums);
        int minimum = Integer.MAX_VALUE;
        int[] answer = new int[2];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int leftValue = nums[left];
            int rightValue = nums[right];
            int result = leftValue + rightValue;
            if (minimum > Math.abs(result)) {
                minimum = Math.abs(result);
                answer[0] = leftValue;
                answer[1] = rightValue;

            }
            if (result > 0) {
                right--;
            } else if (result < 0) {
                left++;
            } else {
                answer[0] = leftValue;
                answer[1] = rightValue;
                break;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
