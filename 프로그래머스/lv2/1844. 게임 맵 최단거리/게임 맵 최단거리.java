import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dirX = { 1, 0, -1, 0 };
    static int[] dirY = { 0, 1, 0, -1 };
    static int[][] visited;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        Point start = new Point(0, 0);
        visited[start.x][start.y] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dirX[i];
                int ny = cur.y + dirY[i];

                if (nx < 0 || ny < 0 || nx > maps.length - 1 || ny > maps[0].length - 1)
                    continue;

                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        bfs(maps);
        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }
}