import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Grade> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                list.add(new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(list);

            int ans = 1;
            int min = list.get(0).b;
            for (int i = 0; i < N; i++) {
                if (list.get(i).b < min) {
                    ans++;
                    min = list.get(i).b;
                }
            }
            System.out.println(ans);
        }
    }
}


class Grade implements Comparable<Grade> {
    int a, b;

    public Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Grade o) {
        if (this.a > o.a) {
            return 1;
        } else {
            return -1;
        }
    }
}