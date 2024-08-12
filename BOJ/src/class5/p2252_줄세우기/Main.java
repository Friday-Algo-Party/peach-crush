package class5.p2252_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] indegree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 학생 수
        N = Integer.parseInt(st.nextToken());
        // 키를 비교한 횟수
        M = Integer.parseInt(st.nextToken());
        // 위상 정렬 알고리즘에서는 진입 차수를 이용해서 정렬 수행
        // 나보다 키가 작은 사람의 수를 저장할 배열
        indegree = new int[N + 1];
        // 나보다 키가 큰 사람들을 저장할 리스트 배열
        graph = new List[N + 1];
        // 리스트 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 키 비교 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 작은 사람의 인덱스
            int a = Integer.parseInt(st.nextToken());
            // 큰 사람의 인덱스
            int b = Integer.parseInt(st.nextToken());
            // 작은 사람의 인덱스(a)에 해당하는 리스트에 큰 사람의 인덱스(b) 추가
            graph[a].add(b);
            // 큰 사람의 인덱스(b)에 해당하는 집입차수 배열 값을 1 증가시켜줌
            // b로 진입하는(= b보다 작은) 노드(= 사람)가 추가되었기 때문
            indegree[b]++;
        }

        // 위상 정렬 수행
        topologicalSort();

    }

    static void topologicalSort() {
        // 큐에 정렬된 순서대로 노드가 들어오고 나올 예정
        Queue<Integer> queue = new LinkedList<>();

        // 집입차수가 0인 노드들을 큐에 추가
        // 진입차수가 0이면 자기 자신보다 작은 노드가 없다는 뜻이기 때문
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        // String 은 값이 달라질 때마다 새로운 객체로 저장됨 -> 문자열이 자주 변경되는 경우 메모리와 성능 효율이 떨어짐
        // StringBuilder 또는 StringBuffer 를 사용하면 하나의 객체에서 값 변경 가능
        // StringBuilder 는 비동기 StringBuffer 는 동기 -> 멀티 스레드 환경에서는 StringBuilder 에 잘못된 문자열이 저장될 수 있음
        StringBuilder sb = new StringBuilder();
        // 큐가 빌 때까지 정렬 수행
        while (!queue.isEmpty()) {
            // 큐에서 현재 노드 빼기 -> 현재 가장 작은 노드
            int cur = queue.poll();
            // 현재 노드는 정렬이 끝났기 때문에 출력 값에 써줌
            sb.append(cur + " ");

            // 현재 노드보다 큰 노드들을 저장해놨던 리스트를 돌면서
            // 진입 차수를 1 감소시켜줌 <- 현재 노드는 이제 처리 완료되어서 나가기 때문에
            for (int next : graph[cur]) {
                indegree[next]--;

                // 진입 차수가 0이되면 자기 자신보다 작은 노드가 없어졌다는 뜻이므로 큐에 넣어줌
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 최종적으로 구해진 정렬 결과 출력
        System.out.println(sb);
    }
}
