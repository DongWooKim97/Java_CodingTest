import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] field;
    static int[] team;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    private static void DFS(int level, int startCount, int index) {
        if (startCount == N / 2) {
            calculateDiff();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                team[level] = i;
                DFS(level + 1, startCount + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDiff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startSum += field[i][j];
                } else if (!visited[i] && !visited[j]) {
                    linkSum += field[i][j];
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
        team = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        DFS(0, 0, 0);
        System.out.println(minDiff);
    }
}
