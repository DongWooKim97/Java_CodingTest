import java.util.*;
import java.util.stream.IntStream;
class Solution {
    static int[] solveA = { 1, 2, 3, 4, 5 };
    static int[] solveB = { 2, 1, 2, 3, 2, 4, 2, 5 };
    static int[] solveC = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();

       int countA = (int) IntStream.range(0, answers.length)
        .filter(idx -> solveA[idx % solveA.length] == answers[idx])
        .count();
int countB = (int) IntStream.range(0, answers.length)
        .filter(idx -> solveB[idx % solveB.length] == answers[idx])
        .count();
int countC = (int) IntStream.range(0, answers.length)
        .filter(idx -> solveC[idx % solveC.length] == answers[idx])
        .count();

        int maxCount = Math.max(countC, Math.max(countA, countB));
        if (maxCount == countA) list.add(1);
        if (maxCount == countB) list.add(2);
        if (maxCount == countC) list.add(3);


        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}