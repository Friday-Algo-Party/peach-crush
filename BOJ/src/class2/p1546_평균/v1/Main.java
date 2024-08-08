package class2.p1546_평균.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 시험 본 과목 개수
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 점수 저장하는 리스트
        List<Integer> scores = new ArrayList<>();

        // 점수 입력
        for (int i = 0; i < N; i++) {
            scores.add(Integer.parseInt(st.nextToken()));
        }

        // 최대 점수 구하기
        int max = Collections.max(scores);
        // 점수 합 구하기
        int sum = scores.stream().mapToInt(Integer::intValue).sum();
        // 새로운 평균 구해서 출력
        double avg = (double) sum / max * 100 / N;
        System.out.println(avg);
    }
}