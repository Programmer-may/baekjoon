import java.util.*;

public class Solution {
    int ans = 0;
    public int solution(int n) {
        while (n != 0) {
            if (n % 2 == 0) {
                n = teleportaion(n);
            } else {
                n = jump(n);
            }
        }
        return ans;
    }

    public int jump(int n) {
        ans++;
        return n - 1;
    }

    public int teleportaion(int n) {
        return n / 2;
    }
}