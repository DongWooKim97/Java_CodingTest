import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            q.offer(day);
        }

        List<Integer> answerList = new ArrayList<>();
        while (!q.isEmpty()) {
            int count = 1;
            int first = q.poll();
            while (!q.isEmpty() && q.peek() <= first) {
                q.poll();
                count++;
            }
            answerList.add(count);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
