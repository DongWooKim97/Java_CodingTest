import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);

        int result1 = gcd(num1, num2);
        int result2 = (num1 * num2) / result1;
        System.out.println(result1);
        System.out.println(result2);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {

            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
