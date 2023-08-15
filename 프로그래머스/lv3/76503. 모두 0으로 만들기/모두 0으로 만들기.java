import java.util.*;

class Solution {
    long answer = 0;
    public long solution(int[] a, int[][] edges) {
        int nodeNum = a.length;
        long[] answerArr = new long[nodeNum + 1];
        for (int i = 0; i < nodeNum; i++) {
            answerArr[i] = a[i];
        }
        List<List<Integer>> connection = new ArrayList<>();

        for (int i = 0; i <= nodeNum; i++) {
            connection.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeNum - 1; i++) {
            connection.get(edges[i][0]).add(edges[i][1]);
            connection.get(edges[i][1]).add(edges[i][0]);
        }
        Stack<Integer> dfs = new Stack<>();
        Stack<Integer> order = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        dfs.push(0);
        visited.add(0);

        while (dfs.size() != 0) {
            int nextNode = dfs.pop();
            order.push(nextNode);
            for (int i = 0; i < connection.get(nextNode).size(); i++) {
                if (!visited.contains(connection.get(nextNode).get(i))) {
                    dfs.push(connection.get(nextNode).get(i));
                    visited.add(connection.get(nextNode).get(i));
                }
            }
        }
        Set<Integer> visited2 = new HashSet<>();
        Set<Integer> leafOfRoot = new HashSet<>();
        leafOfRoot.add(0);
        for (int i = 0; i < connection.get(0).size(); i++) {
            leafOfRoot.add(connection.get(0).get(i));
        }

        while (order.size() != 0) {
            int leafNode = order.pop();
            visited2.add(leafNode);
            if (leafOfRoot.contains(leafNode)) {
                continue;
            }
            for (int i = 0; i < connection.get(leafNode).size(); i++) {
                if (!visited2.contains(connection.get(leafNode).get(i))) {
                    answerArr[connection.get(leafNode).get(i)] += answerArr[leafNode];
                    answer += Math.abs(answerArr[leafNode]);
                }
            }
        }
        long leafOfRootWeight = 0;
        for (int i = 0; i < connection.get(0).size(); i++) {
            leafOfRootWeight += answerArr[connection.get(0).get(i)];
        }
        if (answerArr[0] + leafOfRootWeight == 0) {
            for (int i = 0; i < connection.get(0).size(); i++) {
                answer += Math.abs(answerArr[connection.get(0).get(i)]);
            }
            return answer;
        } else {
            return -1;
        }
    }
}