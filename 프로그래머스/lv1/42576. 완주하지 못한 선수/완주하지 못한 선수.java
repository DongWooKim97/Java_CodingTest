import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String[] parti = new String[]{ "leo", "kiki", "eden" };
        String[] com = new String[]{ "eden", "kiki", };
        System.out.println(new Solution().solution(parti, com));
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion, Comparator.reverseOrder());

        Stack<String> stack = new Stack<>();


        for (String s : participant) {
            stack.push(s);
        }


        for (String s : completion) {
            if (stack.peek().equals(s)) {
                stack.pop();
            }
        }

        return stack.pop();


    }
}