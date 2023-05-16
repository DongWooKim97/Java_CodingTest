import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int N;

    static void permutation(int depth) {
        if (depth == N) {
            calculate();
            return;
        }

        for (int i = depth; i < N; i++) {
            swap(depth, i);
            permutation(depth + 1);
            swap(depth, i);
        }
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void calculate() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        max = Math.max(max, sum);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        permutation(0);
        System.out.println(max);
    }
}
