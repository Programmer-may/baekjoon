import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class User implements Comparable<User> {
        int order;
        int age;
        String name;

        User(int order, int age, String name) {
            this.order = order;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            if (this.age == o.age) {
                return this.order - o.order;
            }
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<User> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            list.add(new User(i, age, name));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            sb.append(user.age).append(" ").append(user.name).append("\n");
        }
        System.out.println(sb);
    }
}