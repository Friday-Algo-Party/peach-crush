package class5.p1197_최소스패닝트리.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // V: 정점의 개수, E: 간선의 개수
    static int V, E;
    // 우선순위큐 -> 비용이 가장 작은 노드부터 퉤하기 위해 사용
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    // 트리의 루트 정보를 저장하는 배열
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점과 간선 개수 입력
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        root = new int[V+1];
        // 루트 배열 초기화 - 자기 자신을 루트로 가지도록
        for (int i = 0; i <= V; i++) {
            root[i] = i;
        }

        // 노드 정보 입력 및 생성된 노드를 우선순위 큐에 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, c));
        }

        // kruskal 알고리즘을 통해 모든 정점들을 연결하는데 드는 최소 가중치의 합 구하기
        long result = kruskal();
        System.out.println(result);
    }

    static long kruskal() {
        // 합친 횟수
        int cnt = 0;
        // 가중치 합
        long sum = 0;

        // 더이상 큐 안에 노드가 들어있지 않을 때까지 반복
        while (!pq.isEmpty()) {
            // 우선순위 큐에 들어있는 노드 꺼내기 -> a노드에서 b노드로 가는데 비용이 가장 적은 노드
            Node node = pq.poll();

            // 노드의 출발지점와 목적지점의 root가 다를 경우 서로 다른 트리에 연결되어 있음
            // 각 트리를 합치고(union()), 합친 횟수를 +1해주고, 가중치의 합에 현재 노드의 가중치(비용)를 더해줌
            if(find(node.from) != find(node.to)) {
                union(node.from, node.to);
                cnt++;
                sum += node.cost;
            }

            // 합쳐진 횟수가 V-1(정점의 개수-1) 이라면 종료
            // why? 모든 정점을 연결하는데 정점 - 1개의 간선만 필요하기 때문에
            // 이 조건이 없어도 정상적으로 동작하지만 이미 최소 스패닝 트리를 구했는데도 나머지 노드에 대해서 돌기 때문에 비효율
            if(cnt == V-1) break;
        }

        // 위 연산을 통해 구해진 가중치 합 리턴
        return sum;
    }

    // 입력받은 정점 a가 포함되는 트리의 루트 노드 구하기
    static int find(int a) {
        if(a == root[a]) return a;
        return root[a] = find(root[a]);
    }

    // 입력받은 정점 a와 b가 포함되는 각 트리를 하나의 트리로 합치기
    static void union(int a, int b) {
        root[find(b)] = find(a);
    }
}

class Node implements Comparable<Node> {
    // 출발지 A에서
    int from;
    // 목적지 B로 가는데
    int to;
    // 드는 비용
    int cost;

    public Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    // Node 간 비교를 할 수 있도록 해주는 메서드
    // Integer.compare() : Integer에 내장되어 있는 비교 메서드
    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}
