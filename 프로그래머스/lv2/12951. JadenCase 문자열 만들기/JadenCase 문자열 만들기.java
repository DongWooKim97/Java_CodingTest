import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println(new Solution().solution("3people unFollowed me"));
        System.out.println(new Solution().solution("for the last week"));

    }
}

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");

        String answer = Arrays.stream(arr)
                .map(e -> {
                    if (e.equals("")) {
                        return "";
                    } else {
                        return String.valueOf(e.charAt(0)).toUpperCase() + e.substring(1).toLowerCase();
                    }
                })
                .collect(Collectors.joining(" "));

        String xAnswer = String.valueOf(s.charAt(s.length() - 1));
        if (xAnswer.equals(" ")) {
            answer += " ";
        }
        return answer;
    }
}