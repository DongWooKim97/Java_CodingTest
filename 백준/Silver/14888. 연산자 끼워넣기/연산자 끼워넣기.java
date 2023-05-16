import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static int[] arr, opt;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void DFS(int level, int[] tmp) {
        if (level == N - 1) {
            int sum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (tmp[i - 1] == 0) sum += arr[i];
                else if (tmp[i - 1] == 1) sum -= arr[i];
                else if (tmp[i - 1] == 2) sum *= arr[i];
                else sum /= arr[i];
            }
            list.add(sum);
        } else {
            for (int i = 0; i < opt.length; i++) {
                if (opt[i] > 0) {
                    tmp[level] = i;
                    opt[i]--;
                    DFS(level + 1, tmp);
                    opt[i]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        opt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        DFS(0, new int[N - 1]);
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
    }

}