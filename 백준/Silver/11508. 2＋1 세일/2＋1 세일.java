import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(sc.nextInt());
        }

        list = list.stream().sorted((a,b) -> b-a).collect(Collectors.toList());
        int sum = 0;
        for (int i = 1; i <= list.size(); i++) {
            if(!(i % 3 == 0)) {
                sum += list.get(i - 1);
            }
        }
        System.out.println(sum);
    }
}
