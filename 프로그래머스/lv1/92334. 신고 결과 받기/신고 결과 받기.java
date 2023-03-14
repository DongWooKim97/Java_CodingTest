
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {

        LinkedHashMap<String, Integer> report_map = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> report_list = new LinkedHashMap<>();

        for (String str : id_list) {
            report_map.put(str, 0);
            report_list.put(str, new ArrayList<>());
        }

        for (String str : report) {
            String reporter = str.split(" ")[0];
            String reported = str.split(" ")[1];

            if (!report_list.get(reporter).contains(reported)) {
                report_list.get(reporter).add(reported);
                report_map.put(reported, report_map.getOrDefault(reported, 0) + 1);
            }
        }

        int[] answer = new int[id_list.length];

        int count = 0;
        for (String str : id_list) {
            List<String> tmp = report_list.get(str);

            for (String s : tmp) {
                if (report_map.get(s) >= k) {
                    answer[count]++;
                }
            }
            count++;
        }

        return answer;
    }
}