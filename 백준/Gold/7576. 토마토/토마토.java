import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] farm;
    static int[][] visited;
    static Queue<Point> q = new LinkedList<>();
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    static void BFS() {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < dirX.length; i++) {
                int nx = cur.x + dirX[i];
                int ny = cur.y + dirY[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && farm[nx][ny] == 0) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    farm[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        farm = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                farm[i][j] = tmp;
                if (tmp == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }

        BFS();

        boolean flag = true;
        for (int[] w : farm) {
            for (int h : w) {
                if (h == 0) {
                    flag = false;
                    break;
                }
            }
        }

        int answer = 0;
        if (flag) {
            for (int[] w : visited) {
                for (int h : w) {
                    answer = Math.max(h, answer);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}