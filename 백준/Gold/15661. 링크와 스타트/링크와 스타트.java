import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int memberNum;
    static int[][] matrix;
    static boolean[] v;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        v = new boolean[n];

        for (int r = 0; r < n; r++) {
            String[] arr = br.readLine().split(" ");
            for (int c = 0; c < n; c++) {
                matrix[r][c] = Integer.parseInt(arr[c]);
            }
        }

        for (memberNum = 0; memberNum < n; memberNum++) {
            dfs(0, 0);
        }

        System.out.println(minDifference);
    }

    private static void dfs(int depth, int start) {
        if (depth == memberNum) {
            calculateDifference();
            if (minDifference == 0) {
                System.out.println(minDifference);
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < n; i++) {
            v[i] = true;
            dfs(depth + 1, i + 1);
            v[i] = false;
        }
    }

    private static void calculateDifference() {
        int startTeam = 0, linkTeam = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (v[i] && v[j]) {
                    startTeam += matrix[i][j] + matrix[j][i];
                } else if (!v[i] && !v[j]) {
                    linkTeam += matrix[i][j] + matrix[j][i];
                }
            }
        }

        int difference = Math.abs(startTeam - linkTeam);
        minDifference = Math.min(minDifference, difference);
    }

}
