import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] rope = new int[N];
        for (int i = 0; i < N; i++) {
            rope[i] = sc.nextInt();
        }
        Arrays.sort(rope);

        int m = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            m = Math.max(m, rope[i] * (N - i));
        }

        System.out.println(m);
        sc.close();
    }
}
