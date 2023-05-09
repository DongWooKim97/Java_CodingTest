import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static int makeAPrice(int P, int W) {
        return P * W;
    }

    static int makeBPrice(int Q, int R, int S, int W) {
        if (W < R) {  // 종민이가 기본요금기준치보다 덜 사용했을 때
            return Q;
        }
        int overPrice = (W - R) * S; // 기본요금기준치보다 더 사용했을떄, 사용한 양의 리터당 금액을 곱하고 기본금액을 더함
        return Q + overPrice;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken()); // A사 기본요금
            int Q = Integer.parseInt(st.nextToken()); // B사 기본요금
            int R = Integer.parseInt(st.nextToken()); // B사 사용기준치
            int S = Integer.parseInt(st.nextToken()); // B사 기준치 이후 추가요금 리터당 금액
            int W = Integer.parseInt(st.nextToken()); // 종민이 사용량

            int ACompanyPrice = makeAPrice(P, W);
            int BCompanyPrice = makeBPrice(Q, R, S, W);

            System.out.printf("#%d %d\n", tc, Math.min(ACompanyPrice, BCompanyPrice));
        }
    }
}
