
import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2); // 가장 바깥쪽 {{ 와 }} 제거
        String[] sBits = s.split("},\\{"); // },{ 로 나누기

        Map<Integer, int[]> elements = Arrays.stream(sBits)
                .map(sBit -> sBit.split(","))
                .map(arr -> Arrays.stream(arr).mapToInt(Integer::parseInt).toArray())
                .collect(Collectors.toMap(arr -> arr.length, arr -> arr));

        Set<Integer> answer = new LinkedHashSet<>();

        IntStream.rangeClosed(1, elements.size())
                .mapToObj(elements::get)
                .forEach(arr -> Arrays.stream(arr).forEach(answer::add));

        return answer
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}