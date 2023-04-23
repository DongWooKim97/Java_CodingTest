import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        for (int i = 1; i <= target; i++) {
            String tmp = String.valueOf(i);
            if (tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
                tmp = tmp.replaceAll("[369]", "-");
                tmp = tmp.replaceAll("[0124578]", "");
            }
            System.out.print(tmp + " ");
        }
    }
}

