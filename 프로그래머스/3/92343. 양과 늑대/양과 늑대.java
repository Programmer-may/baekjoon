import java.util.*;

public class Solution {
    public int solution(int[] info, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }

        // 트리 구성
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree.get(parent).add(child);
        }

        // Stack을 이용한 DFS 탐색
        int maxSheep = 0;
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(0, 0, 0, new ArrayList<>(List.of(0))));

        while (!stack.isEmpty()) {
            State current = stack.pop();
            int node = current.node;
            int sheep = current.sheep;
            int wolf = current.wolf;
            List<Integer> nextNodes = current.nextNodes;

            // 현재 노드에서 양 또는 늑대를 만난다.
            if (info[node] == 0) {
                sheep++;
            } else {
                wolf++;
            }

            // 늑대가 양보다 많거나 같아지면 더 이상 탐색 불가능
            if (wolf >= sheep) continue;

            // 최대 양의 수 갱신
            maxSheep = Math.max(maxSheep, sheep);

            // 다음 가능한 노드 리스트 업데이트
            List<Integer> next = new ArrayList<>(nextNodes);
            next.remove(Integer.valueOf(node));
            next.addAll(tree.get(node));

            // 다음 가능한 모든 노드로 이동
            for (int nextNode : next) {
                stack.push(new State(nextNode, sheep, wolf, new ArrayList<>(next)));
            }
        }

        return maxSheep;
    }

    // 탐색 상태를 관리하는 클래스
    static class State {
        int node; // 현재 노드
        int sheep; // 현재 양의 수
        int wolf; // 현재 늑대의 수
        List<Integer> nextNodes; // 다음 방문 가능한 노드 리스트

        State(int node, int sheep, int wolf, List<Integer> nextNodes) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.nextNodes = nextNodes;
        }
    }
}