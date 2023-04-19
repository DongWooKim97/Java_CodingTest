import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visitied;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visitied = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start);
        System.out.println(sb);

        visitied = new boolean[n + 1];
        bfs(start);
    }

    public static void dfs(int node) {
        visitied[node] = true;
        sb.append(node).append(" ");
        for (int next : graph[node]) {
            if (!visitied[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visitied[node] =true;
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x+" ");
            for (int y : graph[x]) {
                if(visitied[y] == false) {
                    visitied[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
