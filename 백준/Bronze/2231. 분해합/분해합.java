import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(check(target));
    }

    public static int check(int target) {

        for (int i = 1; i < target; i++) {
            int tmp = i;
            String s_target = Integer.toString(tmp);

            for (int j = 0; j < s_target.length(); j++) {
                int x = Integer.parseInt(s_target.substring(j, j + 1));
                tmp += x;
            }

            if (tmp == target) {
                return i;
            }

        }
        return 0;
    }
}
