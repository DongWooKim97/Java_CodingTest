import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {

        String[] answer = Arrays.stream(strings)
                .sorted((a, b) -> {
                    if (a.charAt(n) > b.charAt(n)) {
                        return 1;
                    } else if (a.charAt(n) == b.charAt(n)) {
                        return 0;
                    }
                    return -1;
                })
                .sorted((s1, s2) -> {
                    if (s1.charAt(n) == s2.charAt(n)) {
                        return s1.compareTo(s2);
                    }
                    return 0;
                })
                .toArray(String[]::new);

        return answer;
    }
}