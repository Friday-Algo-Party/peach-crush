package class4.p1753_최단경로.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<Node>[] graph;
    static int[] minDist;
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        minDist = new int[V + 1];
        Arrays.fill(minDist, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            System.out.println(minDist[i]==INF?"INF":minDist[i]);
        }
    }

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(K, 0));
        minDist[K] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.dist <= minDist[cur.to]) {
                for (Node next : graph[cur.to]) {
                    int dist = cur.dist + next.dist;

                    if (dist < minDist[next.to]) {
                        queue.offer(new Node(next.to, dist));
                        minDist[next.to] = dist;
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int to;
    int dist;

    public Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(dist, o.dist);
    }
}