import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input > 0) {
                pQ.add(input);
            } else {
                if (!pQ.isEmpty()) {
                    System.out.println(pQ.poll());
                } else {
                    System.out.println(0);
                }
            }

        }
    }
}