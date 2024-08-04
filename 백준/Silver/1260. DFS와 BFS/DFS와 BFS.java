import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int totalNode = Integer.parseInt(input[0]);
        int totalEdge = Integer.parseInt(input[1]);
        int startNum = Integer.parseInt(input[2]);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= totalNode; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < totalEdge; i++) {
            String[] relation = br.readLine().split(" ");
            int before = Integer.parseInt(relation[0]);
            int after = Integer.parseInt(relation[1]);
            list.get(before).add(after);
            list.get(after).add(before);
        }
        for (List<Integer> rel : list) Collections.sort(rel);

        StringBuilder sb = new StringBuilder();

        boolean[] isVisitedD = new boolean[totalNode + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNum);
        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (!isVisitedD[now]) {
                isVisitedD[now] = true;
                sb.append(now).append(" ");
                List<Integer> rel = list.get(now);
                for (int i = rel.size() - 1; i >= 0; i--) {
                    int num = rel.get(i);
                    if (!isVisitedD[num]) {
                        stack.push(num);
                    }
                }
            }
        }
        sb.append("\n");

        boolean[] isVisitedB = new boolean[totalNode + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        isVisitedB[startNum] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            List<Integer> rel = list.get(now);
            for (int num : rel) {
                if (!isVisitedB[num]) {
                    queue.add(num);
                    isVisitedB[num] = true;
                }
            }
        }
        System.out.println(sb);
    }
}
