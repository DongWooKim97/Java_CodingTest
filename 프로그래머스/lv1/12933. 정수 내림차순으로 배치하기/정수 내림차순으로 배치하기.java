import java.util.*;

class Solution {
    public long solution(long n) {

        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }

        long answer = Long.parseLong(result.reverse().toString());
        return answer;
 
    }
}