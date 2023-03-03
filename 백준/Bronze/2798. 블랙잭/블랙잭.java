import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int card = sc.nextInt();
        int max_num = sc.nextInt();

        int[] arr = new int[card];

        for (int i = 0; i < card; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(check(card, arr, max_num));
    }

    public static int check(int card, int[] arr, int max_num) {
        int max = 0;
        int tmp;
        for (int i = 0; i < card; i++) {
            for (int j = i + 1; j < card; j++) {
                for (int k = j + 1; k < card; k++) {
                    tmp = (arr[i] + arr[j] + arr[k]);
                    if(tmp > max_num) continue;
                    if(tmp > max) {
                        max = tmp;
                    }
                    if (max == max_num) {
                        return max;
                    }
                }
            }
        }
         return max;
    }
}