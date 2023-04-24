import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] maze;
    static int[][] visited;
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    static int N, M;


    static void BFS(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        int move = 1;
        visited[p.x][p.y] = 1;
        while (!q.isEmpty()) {
            Point curP = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curP.x + dirX[i];
                int ny = curP.y + dirY[i];

                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if (maze[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[curP.x][curP.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = tmp[j - 1] - '0';
            }
        }

        Point start = new Point(1, 1);
        BFS(start);

        int answer = visited[N][M];
        System.out.println(answer);
    }
}