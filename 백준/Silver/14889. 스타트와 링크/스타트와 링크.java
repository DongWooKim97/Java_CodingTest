import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] field;
    static int[] visited;
    static int minDiff = Integer.MAX_VALUE;

    private static void DFS(int level, int startCount, int linkCount) {
        if (level == N) {
            if (startCount == N / 2 && linkCount == N / 2) {
                calculateDiff();
            }
            return;
        }

        visited[level] = 1;
        DFS(level + 1, startCount + 1, linkCount);
        visited[level] = 0;
        DFS(level + 1, startCount, linkCount + 1);
    }

    private static void calculateDiff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] == 1 && visited[j] == 1) {
                    startSum += field[i][j];
                    startSum += field[j][i];
                } else if (visited[i] == 0 && visited[j] == 0) {
                    linkSum += field[i][j];
                    linkSum += field[j][i];
                }
            }
        }

        int diff = Math.abs(startSum - linkSum);
        minDiff = Math.min(minDiff, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        visited = new int[N];

        for (int i = 0; i < N; i++) {
            field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        DFS(0, 0, 0);
        System.out.println(minDiff);
    }
}
