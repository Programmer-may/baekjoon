import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static class Trie{
        Trie[] node;
        public Trie() {
            this.node = new Trie[27];

        }
        public void add(String sentence) {
            Trie[] nodes = this.node;
            for (char c : sentence.toCharArray()) {
                int num = c-97;
                if (nodes[num] == null) {
                    nodes[num] = new Trie();
                }
                nodes = nodes[num].node;
            }
        }
        public boolean checkPrefix(String sub_sentence) {
            Trie[] nodes = this.node;
            for (int i = 0; i < sub_sentence.length(); i++) {
                int n = sub_sentence.charAt(i)-97;
                if (nodes[n]==null) {
                    return false;
                }
                nodes = nodes[n].node;
            }
            return true;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Trie node = new Trie();
        while (N-->0){
            node.add(br.readLine());
        }
        while (M-->0){
            boolean check = node.checkPrefix(br.readLine());
            if (check) answer++;
        }
        System.out.println(answer);
    }
}