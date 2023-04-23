import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    private static final int BOARD_SIZE = 8;
    private static final int PIECE = 8;
    static String[][] board;


    static boolean checkCondition() { // 정확히 8개
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].equals("O")) {
                    if (!checkRowAndColumn(i, j)) {
                        return false;
                    }
                    count++;
                }
            }
        }
        return count == PIECE;
    }

    static boolean checkRowAndColumn(int i, int j) {
        for (int x = 0; x < BOARD_SIZE; x++) {
            if (x != i && board[x][j].equals("O")) return false;
        }

        for (int y = 0; y < BOARD_SIZE; y++) {
            if (y != j && board[i][y].equals("O")) return false;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            board = new String[BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                Arrays.fill(board[i], "");
            } // end of sub for-loop

            for (int i = 0; i < BOARD_SIZE; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < BOARD_SIZE; j++) {
                    board[i][j] = String.valueOf(tmp.charAt(j));
                }
            } // end of sub for-loop

            if (checkCondition()) {
                System.out.printf("#%d yes\n", tc);
            } else {
                System.out.printf("#%d no\n", tc);
            }

        } // end of main for-loop

    } // end of main method

}
