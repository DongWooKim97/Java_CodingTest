import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] arr, pm, ch;
    static ArrayList<String> list;

    static void dfs(int level) {
        if (level == N) {
            String str = "";
            for (int i : pm) {
                str += (i + " ");
            }
            list.add(str);
        } else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[level] = arr[i];
                    dfs(level + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        pm = new int[N];
        ch = new int[N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int level = 0;
        dfs(level);

        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
