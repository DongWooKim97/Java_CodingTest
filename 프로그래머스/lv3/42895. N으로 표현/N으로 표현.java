
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import java.util.Set;

class Solution {
    static int max = 8;

    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < max + 1; i++) {
            list.add(new HashSet<>());
        }

        list.get(1).add(N);


        for (int i = 2; i < max + 1; i++) {
            Set<Integer> countSet = list.get(i);

            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i - j);

                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if (preNum != 0 && postNum != 0) {
                            countSet.add(preNum / postNum);
                        }

                    }
                }

                countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }

            for (Set<Integer> sub : list) {
                if (sub.contains(number)) {
                    return list.indexOf(sub);
                }
            }

        }

        return -1;
    }
}