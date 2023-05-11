import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int people = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[people];
        int sum = 0;
        for (int i = 0; i < people; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < people - 1; i++) {
            for (int j = i + 1; j < people; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = arr[j] = 0;
                    Arrays.sort(arr);

                    for (int k = 2; k < people; k++) {
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
    }
}
