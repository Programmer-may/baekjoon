import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K  = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < Math.pow(2,K)-1; i++) {
            int p = Integer.parseInt(st.nextToken());
            list.add(p);
        }

        Node root = Main.buildTree(list,0,list.size()-1);
        printTree(root);
    }
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    static Node buildTree(List<Integer> list, int start, int end){
        if (start>end) {
            return null;
        }
        int rootIdx = (start+end)/2;
        Node root = new Node(list.get(rootIdx));
        if (start==end) {
            return root;
        }
        root.left = buildTree(list,start,rootIdx-1);
        root.right = buildTree(list,rootIdx+1,end);
        return root;
    }
    static void printTree(Node root) {
        StringBuilder sb = new StringBuilder();

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int level = nodeQueue.size();
            for (int i = 0; i<level; i++) {
                Node node = nodeQueue.poll();
                sb.append(node.data + " ");
                if (node.left != null) {
                    nodeQueue.add(node.left);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}