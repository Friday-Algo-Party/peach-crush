package class4.p12865_평범한배낭.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static Stuff[] stuffs;
    static int[][] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stuffs = new Stuff[N+1];
        bag = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            stuffs[i] = new Stuff(W, V);
        }

        for (int i = 1; i <= N; i++) {
            for (int weight = 1; weight <= K; weight++) {
                if(stuffs[i].W <= weight) {
                    bag[i][weight] = Math.max(bag[i-1][weight], bag[i-1][weight - stuffs[i].W] + stuffs[i].V);
                }else {
                    bag[i][weight] = bag[i-1][weight];
                }
            }
        }

        System.out.println(bag[N][K]);
    }
}

class Stuff {
    int W;
    int V;

    public Stuff(int W, int V) {
        this.W = W;
        this.V = V;
    }

}
