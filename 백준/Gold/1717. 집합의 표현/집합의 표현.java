import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;

    public static void main(String[] args) throws IOException {
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        parent = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(info[1]); i++) {
            String[] cmd = br.readLine().split(" ");
            int a = Integer.parseInt(cmd[1]);
            int b = Integer.parseInt(cmd[2]);
            if (cmd[0].equals("0")) {
                union(a, b);
            } else {
                if (find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static int find(int num) {
        if (num == parent[num]) return num;
        else return parent[num] = find(parent[num]);
    }

    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);
        if (findA != findB) parent[findA] = findB;
    }
}
