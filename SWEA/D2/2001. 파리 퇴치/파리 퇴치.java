import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count, N, M;

    static void dfs(Point p) {
        visited[p.x][p.y] = true;

        if (p.x + M - 1 < N && p.y + M - 1 < N) {
            count = Math.max(count, exterm(p));
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                dfs(new Point(nx, ny));
            }
        }
    }

    static int exterm(Point p) {
        int x = p.x;
        int y = p.y;
        int fly = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                fly += arr[x + i][y + j];
            }
        }
        return fly;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                int[] tmp = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                arr[i] = tmp;
            }

            count = 0;
            Point start = new Point(0, 0);
            dfs(start);
            System.out.printf("#%d %d\n", tc, count);
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}