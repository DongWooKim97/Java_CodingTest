import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(BC(sc.nextInt(), sc.nextInt()));
    }

    public static int BC(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        return BC(n - 1, k - 1) + BC(n - 1, k);
    }
}
