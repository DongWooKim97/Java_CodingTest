import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(5, 24));
    }
}

class Solution {
    public String solution(int a, int b) {
        Map<Integer, Integer> map = new HashMap<>() {{
            put(1, 31);
            put(2, 29);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }};

        String[] day = new String[]{ "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int month = 0;

        for (int i = 1; i <= a - 1; i++) {
            month += map.get(i);
        }
        

        return day[(month + b - 1) % 7];
    }
}