package class4.p1149_RGB거리.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 집 개수
        int N = Integer.parseInt(br.readLine());
        // 집을 색칠할 수 있는 모든 경우에 대한 최소 비용 저장하는 배열
        int[][] rgb = new int[3][N];

        // 집을 칠하는 비용 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[0][i] = Integer.parseInt(st.nextToken());
            rgb[1][i] = Integer.parseInt(st.nextToken());
            rgb[2][i] = Integer.parseInt(st.nextToken());
        }

        // 현재 칠하려는 색에 따라서 이전 집의 색이 될 수 있는 색을 칠하는 비용 중 최소 비용을 구해서 더하기
        for (int i = 1; i < N; i++) {
            // 빨간색
            rgb[0][i] += Math.min(rgb[1][i - 1], rgb[2][i - 1]);
            // 초록색
            rgb[1][i] += Math.min(rgb[0][i - 1], rgb[2][i - 1]);
            // 파랑색
            rgb[2][i] += Math.min(rgb[0][i - 1], rgb[1][i - 1]);
        }

        // 마지막 집을 칠하는데 드는 비용 중 최소 비용 구해서 출력
        System.out.println(Math.min(Math.min(rgb[0][N - 1], rgb[1][N - 1]), rgb[2][N - 1]));
    }
}
