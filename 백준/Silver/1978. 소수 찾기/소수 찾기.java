import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main f = new Main();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(f.solution(arr));

    }

    public int solution(int[] arr) {
        int result = 0;
        int[] list = {2, 3, 5, 7};

        for (int x : arr) {
            if (x != 1) {
                boolean check = true;
                if (x < 10) {
                    for (int i = 2; i < x; i++) {
                        if (x % i == 0) {
                            check = false;
                            break;
                        }
                    }
                } else {
                    for (int i = 2; i <= (int) Math.sqrt(x); i++) {
                        if (x % i == 0) {
                            check = false;
                            break;
                        }

                    }
                }
                if (check) result++;
            }
        }


        return result;
    }
}
