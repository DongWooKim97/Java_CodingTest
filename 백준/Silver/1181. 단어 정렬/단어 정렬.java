import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] arr = new String[len];

        for (int i = 0; i < len; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });


        LinkedHashSet<String> lh = new LinkedHashSet<>(Arrays.asList(arr));
        String[] result = lh.toArray(new String[0]);

        for (String s : result) {
            System.out.println(s);
        }


    }
}

