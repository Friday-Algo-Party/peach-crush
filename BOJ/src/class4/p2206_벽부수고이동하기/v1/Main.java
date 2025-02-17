import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] graph;
    static int[][] distance;
    static boolean[][][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i = 0;i<N;i++){
            String tmp = br.readLine();
            for(int j = 0;j<M;j++){
                graph[i][j] = tmp.charAt(j) - '0';
            }
        }

        bfs(0,0);
    }

    static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,y,x});
        visited[0][y][x] = true;
        distance[y][x] = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int isBroken = cur[0];
            int cy = cur[1];
            int cx = cur[2];
            if(cy == N-1 && cx == M-1){
                System.out.println(distance[cy][cx]);
                return;
            }
            for(int i = 0;i<4;i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(ny>=0 && ny<N && nx>=0 && nx<M){
                    if(graph[ny][nx] == 1){
                        if(isBroken==0 && !visited[1][ny][nx]){
                            visited[1][ny][nx] = true;
                            distance[ny][nx] = distance[cy][cx] + 1;
                            queue.offer(new int[]{1,ny,nx});
                        }
                    }else{
                        if(!visited[isBroken][ny][nx]){
                            visited[isBroken][ny][nx] = true;
                            distance[ny][nx] = distance[cy][cx] + 1;
                            queue.offer(new int[]{isBroken,ny,nx});
                        }
                    }
                }
            }
        }
        System.out.println(-1);;
    }
}
