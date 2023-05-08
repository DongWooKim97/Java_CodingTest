import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        if (N == 1) {
            System.out.println(list.get(0));
            return;
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < list.get(0).length()) {
            char c = list.get(0).charAt(idx);
            boolean check = true;
            for (String s : list) {
                if (s.charAt(idx) != c) {
                    check = false;
                    break;
                }
            }
            if (check) sb.append(c);
            else sb.append("?");
            idx++;
        }
        System.out.println(sb.toString());
    }
}
