import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static boolean[] visited;
    static int second;
    static int[] move = {1, -1, 2};

    static void bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();

            for (int j = 0; j < len; j++) {
                int cur = q.poll();
                if (cur == K) {
                    second = level;
                    return;
                }
                if ((cur + 1) < 100001 && (cur + 1) >= 0 && !visited[cur + 1]) {
                    visited[cur + 1] = true;
                    q.offer(cur + 1);
                }
                if ((cur - 1) < 100001 && (cur - 1) >= 0 && !visited[cur - 1]) {
                    visited[cur - 1] = true;
                    q.offer(cur - 1);
                }
                if ((cur * 2) < 100001 && (cur * 2) >= 0 && !visited[cur * 2]) {
                    visited[cur * 2] = true;
                    q.offer(cur * 2);
                }
            }
            level++;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[100001];
        visited = new boolean[100001];
        second = 0;
        bfs(N, K);
        System.out.println(second);
    }
}
