import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int answer = 0;
    static long[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(arr[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            twoPointer(i);
        }
        System.out.println(answer);
    }

    private static void twoPointer(int idx) {
        int left = 0;
        int right = nums.length - 1;
        long target = nums[idx];

        while (left < right) {
            if (left == idx) {
                left++;
                continue;
            }
            if (right == idx) {
                right--;
                continue;
            }

            long sum = nums[left] + nums[right];
            if (sum == target) {
                answer++;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
