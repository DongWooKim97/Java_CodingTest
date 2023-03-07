import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String s) {
        Map<String, String> map = new HashMap<>() {{
            put("zero", "0");
            put("one", "1");
            put("two", "2");
            put("three", "3");
            put("four", "4");
            put("five", "5");
            put("six", "6");
            put("seven", "7");
            put("eight", "8");
            put("nine", "9");
        }};

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                result += s.charAt(i);
            } else {
                String tmp = "";
                for (int j = i; j < s.length(); j++) {
                    tmp += s.charAt(j);
                    if (map.containsKey(tmp)) {
                        result += map.get(tmp);
                        break;
                    }
                }
            }
        }

                return Integer.parseInt(result);
    }
}