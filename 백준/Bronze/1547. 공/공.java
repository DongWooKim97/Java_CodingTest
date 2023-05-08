import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] arr = new int[4];
        for (int i = 1; i <= 3; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            int tmp = arr[to];
            arr[to] = arr[from];
            arr[from] = tmp;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
