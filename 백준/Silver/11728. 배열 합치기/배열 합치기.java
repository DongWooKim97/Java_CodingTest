import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        int[] a = new int[aSize];
        int[] b = new int[bSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int[] result = new int[aSize + bSize];

        int p1 = 0, p2 = 0, idx = 0;
        while (p1 < aSize && p2 < bSize) {
            if (a[p1] < b[p2]) {
                result[idx++] = a[p1++];
            } else {
                result[idx++] = b[p2++];
            }
        }

        while (p2 < bSize) {
            result[idx++] = b[p2++];
        }

        while (p1 < aSize) {
            result[idx++] = a[p1++];
        }


        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
