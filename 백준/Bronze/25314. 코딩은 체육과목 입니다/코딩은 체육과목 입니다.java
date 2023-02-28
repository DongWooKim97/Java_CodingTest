import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        String answer = "int";

        for (int i = 0; i < target / 4; i++) {
            answer = "long " + answer;
        }

        System.out.println(answer);
    }
}
