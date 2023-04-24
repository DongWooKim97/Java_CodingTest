import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n) {
        List<Point> list = hanoi(n, 1, 3);
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).start;
            answer[i][1] = list.get(i).to;
        }
        return answer;
    }

    List<Point> hanoi(int ring, int start, int to) {
        List<Point> tmp = new ArrayList<>();
        int via = 0;
        boolean[] tower = new boolean[4];
        tower[start] = true;
        tower[to] = true;

        for (int i = 1; i < tower.length; i++) {
            if (!tower[i]) {
                via = i;
                break;
            }
        }

        if (ring == 1) {
            tmp.add(new Point(start, to));
            return tmp;
        }

        tmp.addAll(hanoi(ring - 1, start, via));
        tmp.addAll(hanoi(1, start, to));
        tmp.addAll(hanoi(ring - 1, via, to));
        return tmp;
    }
}

class Point {
    int start;
    int to;

    Point(int start, int to) {
        this.start = start;
        this.to = to;
    }
}