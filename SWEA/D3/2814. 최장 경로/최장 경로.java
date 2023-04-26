import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] graph;
    static boolean[] visited;

    public static int dfs(int start) {
        int maxLen = 0;
        visited[start] = true;

        for (int i = 1; i < graph[start].length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                maxLen = Math.max(maxLen, dfs(i));
            }
        }

        visited[start] = false;
        return maxLen + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = graph[to][from] = 1;
            }

            int maxLength = 0;
            for (int i = 1; i <= N; i++) {
                maxLength = Math.max(maxLength, dfs(i));
            }
            System.out.printf("#%d %d\n", test_case, maxLength);
        }
    }
}
