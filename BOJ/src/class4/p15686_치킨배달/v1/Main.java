package class4.p15686_치킨배달.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int HOUSE = 1;
    static final int CHICKEN = 2;
    static int N, M;
    static int[][] graph;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int[] distances;
    static int[] remain;
    static int minCityChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        remain = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == HOUSE) {
                    houses.add(new int[]{i, j});
                }

                if (graph[i][j] == CHICKEN) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        distances = new int[houses.size()];

        selectChicken(0, 0);

        System.out.println(minCityChickenDistance);
    }

    static void selectChicken(int depth, int idx) {
        if(depth == M) {
            minCityChickenDistance = Math.min(minCityChickenDistance, getCityChickenDistance());
        } else {
            for(int i = idx; i < chickens.size(); i++) {
                remain[depth] = i;
                selectChicken(depth+1, i+1);
            }
        }
    }

    static int getCityChickenDistance() {
        Arrays.fill(distances, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            int[] chicken = chickens.get(remain[i]);

            for (int j = 0; j < houses.size(); j++) {
                int[] house = houses.get(j);
                int distance = getChickenDistance(chicken[0], chicken[1], house[0], house[1]);
                distances[j] = Math.min(distances[j], distance);
            }
        }

        int sum = 0;

        for (int distance : distances) {
            sum += distance;
        }

        return sum;
    }

    static int getChickenDistance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }
}
