import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static int result;

    static void dfs(int count, int start, char[] numbers) {
        if (count == 0) {
            int cur = charArrToInt(numbers);
            if (cur > result) {
                result = cur;
            }
            return;
        }

        for (int i = start; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                numbers = swap(i, j, numbers);
                dfs(count - 1, i, numbers);
                numbers = swap(i, j, numbers);
            }
        }

    }

    private static char[] swap(int i, int j, char[] numbers) {
        char tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;

        return numbers;
    }


    private static int charArrToInt(char[] numbers) {
        return Integer.parseInt(new String(numbers));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] tmp = br.readLine().split(" ");
            int number = Integer.parseInt(tmp[0]);
            int count = Integer.parseInt(tmp[1]);

            char[] numbers = Integer.toString(number).toCharArray();
            result = 0;

            if (numbers.length < count) count = numbers.length;
            dfs(count, 0, numbers);
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
