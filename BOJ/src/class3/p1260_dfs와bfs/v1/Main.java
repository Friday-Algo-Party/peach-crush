package class3.p1260_dfs와bfs.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수
        N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        M = Integer.parseInt(st.nextToken());
        // 탐색을 시작할 정점의 번호
        V = Integer.parseInt(st.nextToken());

        // 각 노드에 연결된 노드들을 저장할 리스트 배열
        graph = new ArrayList[N+1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 입력 받은 노드들을 양방향으로 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 각 노드에 연결된 노드들을 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 노드 방문 여부를 저장하는 배열 초기화
        visited = new boolean[N+1];
        // dfs 수행
        dfs(V);
        sb.append("\n");
        // bfs를 위해 visited 배열 다시 초기화
        visited = new boolean[N+1];
        // bfs 수행
        bfs();
        // 결과 출력
        System.out.println(sb);
    }

    static void dfs(int x) {
        // 현재 노드 x를 방문 처리
        visited[x] = true;
        sb.append(x + " ");

        // x에 연결된 노드들이 아직 방문 전이라면 dfs를 재귀적으로 호출하며 방문
        for(int next : graph[x]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        // 큐에 탐색을 시작할 정점을 넣고 방문처리 후 시작
        queue.offer(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            // 큐에서 나오는 순서가 노드를 방문한 순서
            int cur = queue.poll();
            sb.append(cur + " ");

            // 현재 노드 cur에 연결된 노드들이 아직 방문 전이라면 큐에 넣고 방문 처리
            for (Integer next : graph[cur]) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

    }
}
