import java.util.*;

class Solution {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> isVisited = new HashSet<>();
    List<List<Integer>> tree = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        // 연결 리스트로 트리 구조 만들기
        // 와이어 선을 하나씩 잘라 자른 두 부분을 루트 노드 삼아서 연결된 송전 탑 갯수를 세고 뺀 절대값을 넣기
        // 최솟값 도출
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] connection : wires) {
            int from = connection[0];
            int to = connection[1];
            tree.get(from).add(to);
            tree.get(to).add(from);
        }
        PriorityQueue<Integer> candidate = new PriorityQueue<>();
        for (int[] connection : wires) {
            int from = connection[0];
            int to = connection[1];
            tree.get(from).remove((Object) to);
            tree.get(to).remove((Object) from);
            int boundary = countTower(from);
            int anotherBoundary = countTower(to);
            candidate.add(Math.abs(boundary - anotherBoundary));
            tree.get(from).add(to);
            tree.get(to).add(from);
        }
        return candidate.poll();
    }
    private int countTower(int root) {
        isVisited.clear();
        queue.add(root);
        isVisited.add(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                cnt++;
                List<Integer> next = tree.get(num);
                for (int nextNum : next) {
                    if (!isVisited.contains(nextNum)) {
                        queue.add(nextNum);
                        isVisited.add(nextNum);
                    }
                }
            }
        }
        return cnt;
    }
}