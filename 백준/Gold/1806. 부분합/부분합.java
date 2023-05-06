import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0;
        int sum = arr[lt];
        int len = 1;
        int min = Integer.MAX_VALUE;
        while (lt < N) {
            if (sum < S) {
                if (++rt < N) {
                    sum += arr[rt];
                    len++;
                } else {
                    break;
                }
            } else {
                min = Math.min(len, min);
                sum -= arr[lt++];
                len--;
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
