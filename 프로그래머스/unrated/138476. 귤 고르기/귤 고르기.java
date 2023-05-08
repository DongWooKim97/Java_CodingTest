import java.util.*;

class Solution {
    static Map<Integer, Integer> map = new HashMap<>();

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, new customComparator());

        for (Integer e : keyList) {
            if (k <= 0) break;
            answer++;
            k -= map.get(e);
        }

        return answer;
    }

    static class customComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }
}