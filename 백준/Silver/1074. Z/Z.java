import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, count;

    static int z(int row, int col, int size) {
        if (size == 1) {
            return count;
        }

        int half = size / 2;
        int skip = half * half;

        if (r < row + half && c < col + half) {
            return z(row, col, half);
        } else if (r < row + half && c >= col + half) {
            count += skip;
            return z(row, col + half, half);
        } else if (r >= row + half && c < col + half) {
            count += skip * 2;
            return z(row + half, col, half);
        } else {
            count += skip * 3;
            return z(row + half, col + half, half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        count = 0;

        System.out.println(z(0, 0, size));
    }
}
