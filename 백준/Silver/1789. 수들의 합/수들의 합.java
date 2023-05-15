import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long inp = sc.nextLong();

        System.out.println(Search_N(inp));
        sc.close();
    }

    public static int Search_N(long S) {
        int N = 0;
        long sum = 0L;
        int i = 0;
        while (true) {
            sum += ++i;
            if (sum > S) {
                return N;
            }
            N++;
        }
    }
}
