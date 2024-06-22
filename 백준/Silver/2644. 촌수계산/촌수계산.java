import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalPeople = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        int start = Integer.parseInt(info[0]);
        int target = Integer.parseInt(info[1]);
        int m = Integer.parseInt(br.readLine());
        List<List<Integer>> relation = new ArrayList<>();
        for (int i = 0; i <= totalPeople; i++) {
            relation.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] family = br.readLine().split(" ");
            int parents = Integer.parseInt(family[0]);
            int child = Integer.parseInt(family[1]);
            relation.get(parents).add(child);
            relation.get(child).add(parents);
        }
        br.close();

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int lev = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int y = 0; y < size; y++) {
                int now = queue.poll();
                if (now == target) {
                    bw.write(String.valueOf(lev));
                    bw.flush();
                    bw.close();
                    return;
                }
                List<Integer> family = relation.get(now);
                for (int next : family) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            lev++;
        }
        bw.write(String.valueOf(-1));
        bw.flush();
        bw.close();
    }
}
