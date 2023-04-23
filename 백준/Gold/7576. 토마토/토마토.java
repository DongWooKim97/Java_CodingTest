import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    private static final int[] moveDirectionX = {1, 0, -1, 0};
    private static final int[] moveDirectionY = {0, 1, 0, -1};
    private static final int numberDirectionMovement = 4;

    static int n, m;
    static int[][] graph, distance;
    static Queue<Point> q = new LinkedList<>();

    static void BFS() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < numberDirectionMovement; i++) {
                int nextX = tmp.x + moveDirectionX[i];
                int nextY = tmp.y + moveDirectionY[i];
                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && graph[nextX][nextY] == 0) {
                    distance[nextX][nextY] = distance[tmp.x][tmp.y] + 1;
                    graph[nextX][nextY] = 1;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        graph = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }

        BFS();

        boolean flag = true;
        for (int[] w : graph) {
            for (int h : w) {
                if (h == 0) {
                    flag = false;
                    break;
                }
            }
        }

        int answer = 0;
        if (flag) {
            for (int[] w : distance) {
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