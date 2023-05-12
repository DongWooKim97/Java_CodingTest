import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int btnA = 300, btnB = 60, btnC = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        if (T % btnC != 0) {
            System.out.println(-1);
        } else {
            int ctnA = 0;
            int ctnB = 0;
            int ctnC = 0;
            while (T > 1) {
                if (T % btnA == 0) {
                    ctnA = T / btnA;
                    break;
                } else if (T > btnA) {
                    T -= btnA;
                    ctnA++;
                } else if (T % btnB == 0) {
                    ctnB++;
                    T -= btnB;
                } else {
                    ctnC++;
                    T -= btnC;
                }
            }
            System.out.println(ctnA + " " + ctnB + " " + ctnC);
        }
    }
}
