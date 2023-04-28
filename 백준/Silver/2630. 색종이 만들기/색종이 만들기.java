import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, white, blue;

    static void parition(int i, int j, int size) {

        if (check(i, j, size)) {
            if (map[i][j] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        parition(i, j, newSize);
        parition(i, j + newSize, newSize);
        parition(i + newSize, j, newSize);
        parition(i + newSize, j + newSize, newSize);

    }

    static boolean check(int i, int j, int size) {
        int color = map[i][j];
        
        for (int row = i; row < i + size; row++) {
            for (int col = j; col < j + size; col++) {
                if (map[row][col] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        white = 0;
        blue = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        parition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
}