import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y] = true;
        int town = 1;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Point now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dirX[j];
                    int ny = now.y + dirY[j];

                    if (nx >= 0 && nx < T && ny >= 0 && ny < T && !visited[nx][ny] && arr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        town++;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return town;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[T][T];
        visited = new boolean[T][T];

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            for (int j = 0; j < T; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    pq.offer(bfs(new Point(i, j)));
                }
            }
        }

        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
