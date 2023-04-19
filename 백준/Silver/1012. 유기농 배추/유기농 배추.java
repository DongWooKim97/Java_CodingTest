import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h, vege;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dirX = { 0, -1, 0, 1 };
    static int[] dirY = { 1, 0, -1, 0 };
    static int count;


    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int cx = x + dirX[i];
            int cy = y + dirY[i];
            if (cx >= 0 && cy >= 0 && cx < w && cy < h) {
                if (!visited[cx][cy] && graph[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            vege = Integer.parseInt(st.nextToken());

            graph = new int[w][h];
            visited = new boolean[w][h];

            for (int j = 0; j < vege; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                graph[p1][p2] = 1;
            }

            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    if (graph[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
