import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    static int[] num;
    static boolean[] isVisited;

    static List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }
        isVisited = new boolean[N];
        dfs(new StringBuilder(), 0);
        for (String sequence : answers) {
            System.out.println(sequence);
        }
    }

    private static void dfs(StringBuilder sb, int depth) {
        if (depth == M) {
            answers.add(sb.toString().trim());
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                int sbLength = sb.length();
                sb.append(num[i]).append(" ");
                dfs(sb, depth + 1);
                sb.setLength(sbLength);
                isVisited[i] = false;
            }
        }
    }
}