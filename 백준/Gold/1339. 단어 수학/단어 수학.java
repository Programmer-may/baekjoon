import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            list.add(word);
            int length = word.length();
            for (int j = 0; j < length; j++) {
                char ch = word.charAt(j);
                int weight = (int) Math.pow(10, length - j - 1);
                map.put(ch, map.getOrDefault(ch, 0) + weight);
            }
        }
        
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());
        int idx = 9;
        for (Map.Entry<Character, Integer> entry : entries) {
            map.put(entry.getKey(), idx--);
        }
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            for (char c : s.toCharArray()) {
                sb.append(map.get(c));
            }
            answer += Integer.parseInt(sb.toString());
            sb.setLength(0);
        }
        System.out.println(answer);
    }
}
