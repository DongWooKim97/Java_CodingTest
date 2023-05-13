import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int level;

    static void bfs(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String now = q.poll();
                if (now.equals(target)) return;

                for (int j = 0; j < words.length; j++) {
                    if (isConvetible(now, words[j])) {
                        q.offer(words[j]);
                    }
                }
            }
            level++;
        }
    }

    static boolean isConvetible(String word1, String words2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != words2.charAt(i)) diffCount++;
            if (diffCount > 1) return false;
        }
        return true;
    }

    public int solution(String begin, String target, String[] words) {
        boolean isExist = Arrays.stream(words).anyMatch(target::equals);
        if (!isExist) return 0;
        level = 0;
        bfs(begin, target, words);
        return level;
    }
}
