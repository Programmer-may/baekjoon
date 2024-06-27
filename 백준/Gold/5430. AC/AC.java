import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalTestCase = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= totalTestCase; testCase++) {
            String commands = br.readLine().trim();
            int n = Integer.parseInt(br.readLine().trim());
            String arrayInput = br.readLine().trim();
            Deque<Integer> deque = new LinkedList<>();
            if (n > 0) {
                String[] numbers = arrayInput.substring(1, arrayInput.length() - 1).split(",");
                for (String number : numbers) {
                    deque.add(Integer.parseInt(number));
                }
            }
            solution(commands, deque);
        }
        System.out.print(sb.toString());
    }

    private static void solution(String commands, Deque<Integer> deque) {
        boolean isReversed = false;
        boolean isError = false;
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                isReversed = !isReversed;
            } else {
                if (deque.isEmpty()) {
                    isError = true;
                    break;
                } else {
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }
        }

        if (isError) {
            sb.append("error\n");
        } else {
            sb.append("[");
            if (isReversed) {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]\n");
        }
    }
}