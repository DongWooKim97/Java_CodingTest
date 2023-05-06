import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                map.put(name, map.getOrDefault(map.get(name), 0) + 1);
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s) > 0) {
                list.add(s);
            }
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
