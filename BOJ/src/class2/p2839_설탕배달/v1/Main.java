package class2.p2839_설탕배달.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 최대값 - 10의 9승 => 10억
    // N의 최대값이 5000이므로 제일 작은 값인 3으로 나눴을 때 최대 1666이 나올 수 있으므로 1667를 MAX로 잡아도 괜츈
    // BUT 최대값 생각하기 귀찮아서 보통 10억 많이 씀
    static final int MAX = (int) 1e9;
    // 봉지 무게를 저장하고 있는 배열
    static final int[] WEIGHTS = {3, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배달해야 하는 설탕 무게
        int N = Integer.parseInt(br.readLine());
        // 각 무게 별로 최소 봉지 수를 저장하는 배열
        int[] dp = new int[N + 1];
        // 최대 값으로 배열 요소의 값을 초기화해줌 -> 그래야 처음으로 min 함수 사용했을 때 계산한 값이 들어올 수 있기 때문에
        Arrays.fill(dp, MAX);
        // 0으로 초기화 해놔야 3-3(or 5-5) 했을 때 dp[3](or dp[5])에 1이 저장될 수 있기 때문에
        dp[0] = 0;

        // 각 무게 별로 최소 봉지 수를 구하기
        for (int weight = 1; weight <= N; weight++) {
            for (int i = 0; i < WEIGHTS.length; i++) {
                // 이전 무게로 가능한 무게 구하기 (현재 무게 - 3 or 현재 무게 - 5)
                int prevWeight = weight - WEIGHTS[i];

                // 무게는 0 이상이어야 하고
                // 해당 무게를 나누는데 필요한 최소 봉지 수가 -1이라면 나누는게 불가능한 무게이므로
                // 아래 조건식을 만족할 때만 현재 무게를 나누는데 필요한 최소 봉지 수 구하기
                if (prevWeight >= 0 && dp[prevWeight] != -1) {
                    // 현재까지 구해진 최소 봉지수와 이전 무게에서의 최소 봉지수 + 1를 비교해서 더 작은 값으로 저장
                    dp[weight] = Math.min(dp[weight], dp[prevWeight] + 1);
                }
            }

            // 해당 무게를 나누는데 필요한 최소 봉지 수가 MAX(10억)이라면 위 로직에서 해당 무게를 나눈는 것이 불가능했다는 의미
            // 우리는 안 나눠지는 경우 -1을 출력해야하므로 -1을 저장해줌
            if (dp[weight] == MAX) {
                dp[weight] = -1;
            }
        }

        // 최종적으로 구해진 N킬로그램의 설탕을 나누는데 필요한 최소 봉지수를 출력
        System.out.println(dp[N]);
    }
}
