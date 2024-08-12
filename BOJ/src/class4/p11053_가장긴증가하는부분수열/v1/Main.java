package class4.p11053_가장긴증가하는부분수열.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 크기
        int N = Integer.parseInt(br.readLine());
        // 수열을 이루고 있는 요소들을 저장할 배열
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열의 각 요소들을 입력받아서 배열에 저장
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 증가하는 부분 수열의 길이를 저장할 배열
        int[] dp = new int[N + 1];
        dp[0] = 0;
        // dp에 저장된 값 중에 가장 큰 값을 저장
        int max = 0;

        // 가장 긴 증가하는 부분 수열의 길이 구하기
        for (int cur = 1; cur <= N; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                // arr 배열에서 cur 인덱스에 해당하는 값이 prev(cur 보다 전에 있는 인덱스) 인덱스에 해당하는 값보다 크다면 증가 중이기 때문에
                // 가장 긴 증가하는 부분 수열의 길이를 저장하고 있는 dp[cur] 값을 갱신
                if (arr[cur] > arr[prev]) {
                    // dp[prev] + 1 이 현재 가장 긴 증가하는 부분 수열의 길이가 될 수 있기 때문에
                    // 이 값과 현재 dp[cur]에 저장되어 있는 값을 비교해서 큰 값을 저장
                    dp[cur] = Math.max(dp[cur], dp[prev] + 1);
                    // 구해진 dp[cur] 값이 max보다 클 경우 max 값 갱신
                    max = Math.max(max, dp[cur]);
                }
            }
        }

        // 최종적으로 구해진 max 값(= 가장 긴 증가하는 부분 수열의 길이) 출력
        System.out.println(max);
    }
}
