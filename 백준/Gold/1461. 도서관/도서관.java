import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        List<Integer> negativeNode = new ArrayList<>();
        List<Integer> positiveNode = new ArrayList<>();
        String[] nodes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(nodes[i]);
            if (num > 0) positiveNode.add(num);
            else negativeNode.add(Math.abs(num));
        }
        negativeNode.sort(Collections.reverseOrder());
        positiveNode.sort(Collections.reverseOrder());

        int totalDistance = 0;
        for (int i = 0; i < negativeNode.size(); i += m) {
            totalDistance += negativeNode.get(i) * 2;
        }
        for (int i = 0; i < positiveNode.size(); i += m) {
            totalDistance += positiveNode.get(i) * 2;
        }

        int maxDistance = 0;
        if (!negativeNode.isEmpty()) maxDistance = Math.max(maxDistance, negativeNode.get(0));
        if (!positiveNode.isEmpty()) maxDistance = Math.max(maxDistance, positiveNode.get(0));
        System.out.println(totalDistance - maxDistance);
    }
}
