package class3.p1463_1로만들기.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연산을 적용할 정수
        int N = Integer.parseInt(br.readLine());

        // 정수별로 1이 되기까지 최소 연산횟수를 저장할 배열
        int[] dp = new int[N + 1];

        // 정수 i가 1이 되는데 필요한 최소 연산횟수 구하기
        for (int i = 2; i <= N; i++) {
            // 3번 1을 빼는 연산 수행
            dp[i] = dp[i - 1] + 1;

            // 1번 3으로 나누어 떨어질 경우 3으로 나누는 연산 수행
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            // 2번 2로 나누어 떨어질 경우 2로 나누는 연산 수행
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        // 결과 출력
        System.out.println(dp[N]);
    }
}
