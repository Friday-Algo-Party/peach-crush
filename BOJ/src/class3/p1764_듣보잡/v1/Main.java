package class3.p1764_듣보잡.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> noListen = new HashSet<>();
        Set<String> noSee = new HashSet<>();

        for (int i = 0; i < N; i++) {
            noListen.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            noSee.add(br.readLine());
        }

        Set<String> noListenNoSee = new TreeSet<>(noListen);
        noListenNoSee.retainAll(noSee);

        System.out.println(noListenNoSee.size());
        for(String name : noListenNoSee) {
            System.out.println(name);
        }
    }
}
