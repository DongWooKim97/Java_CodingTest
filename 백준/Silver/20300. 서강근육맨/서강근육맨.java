import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        long[] arr = new long[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        List<Long> result = new ArrayList<>();

        if (size % 2 == 0) {
            for (int i = 0; i < size / 2; i++) {
                result.add(arr[i] + arr[size - 1 - i]);
            }
        } else {
            for (int i = 0; i < (size - 1) / 2; i++) {
                result.add(arr[i] + arr[size - 2 - i]);
            }
            result.add(arr[size- 1]);
        }

        System.out.println(Collections.max(result));
    }
}
