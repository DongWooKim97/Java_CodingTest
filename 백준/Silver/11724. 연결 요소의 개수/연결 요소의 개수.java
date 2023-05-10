import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int N, M;

    static void dfs(int i) {
        visited[i] = true;

        for (int x = 0; x < graph[i].length; x++) {
            if (i != x && graph[i][x] == 1 && !visited[x]) {
                dfs(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        graph = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            String[] vertex = br.readLine().split(" ");
            int from = Integer.parseInt(vertex[0]);
            int to = Integer.parseInt(vertex[1]);
            graph[from - 1][to - 1] = graph[to - 1][from - 1] = 1;
        }

        int count = 0;
        count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {  // 이전에 방문한 적 없는 노드에 대해서만 DFS 수행
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }
}