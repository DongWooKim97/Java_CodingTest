import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input > 0) {
                pQ.offer(input);
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
