import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final long INF = 5000001;
    static int N, M;
    static long[] dist;
    static Bus[] busRoutes;

    static class Bus {
        int start, end, time;

        Bus(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        busRoutes = new Bus[M];
        for (int i = 0; i < M; i++) {
            String[] info = br.readLine().split(" ");
            busRoutes[i] = new Bus(Integer.parseInt(info[0]), Integer.parseInt(info[1]),Integer.parseInt(info[2]));
        }
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 벨만 포드 알고리즘
        if (bellmanFord()) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
    static boolean bellmanFord() {
        // N-1번 반복
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Bus bus = busRoutes[j];
                if (dist[bus.start] != INF && dist[bus.end] > dist[bus.start] + bus.time) {
                    dist[bus.end] = dist[bus.start] + bus.time;
                }
            }
        }
        // N번째에 음수 사이클이 있는지 확인
        for (int j = 0; j < M; j++) {
            Bus bus = busRoutes[j];
            if (dist[bus.start] != INF && dist[bus.end] > dist[bus.start] + bus.time) {
                return true; // 음수 사이클 존재
            }
        }
        return false;
    }
}
