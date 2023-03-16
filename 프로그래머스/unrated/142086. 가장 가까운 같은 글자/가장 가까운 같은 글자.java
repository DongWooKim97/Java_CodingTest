import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    public int[] solution(String s) {
        Map<String, List<Integer>> map = new HashMap<>();
        int[] answer = new int[s.length()];

        for (String str : s.split("")) {
            map.put(str, new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            String tmp = String.valueOf(s.charAt(i));
            map.get(tmp).add(i);
        }

        String result = "";
        System.out.println(map);

        for (int i = 0; i < s.length(); i++) {
            String tmp = String.valueOf(s.charAt(i));
            if (!result.contains(tmp)) {
                answer[i] = -1;
            } else {
                answer[i] = i - result.lastIndexOf(tmp);
            }

            result += tmp;
        }
        return answer;
    }
}