import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split(" ");
        int total= Integer.parseInt(sp[0]);
        int target = Integer.parseInt(sp[1]);

        Map<String, Integer> map = new LinkedHashMap<>();
        String[] index = new String[total+1];
       
        for (int i = 1; i <= total; i++) {
            String tmp = sc.next();
            map.put(tmp, i);
            index[i] = tmp;
        }

        for (int i = 0; i < target; i++) {
            String str = sc.next();
            if (isInteger(str)) {
                int tmp = Integer.parseInt(str);
                System.out.println(index[tmp]);
            } else {
                System.out.println(map.get(str));
            }
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
