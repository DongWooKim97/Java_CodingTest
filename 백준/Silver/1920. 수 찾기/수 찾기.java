import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int lt = 0, rt = n - 1;
            boolean condition = false;
            while (lt <= rt) {
                int mid = lt + (rt - lt) / 2;
                if (targets[i] == arr[mid]) {
                    System.out.println(1);
                    condition = true;
                    break;
                } else if (targets[i] < arr[mid]) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            if (!condition) System.out.println(0);
        }
    }
}
