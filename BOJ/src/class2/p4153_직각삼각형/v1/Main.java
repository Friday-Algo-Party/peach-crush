package class2.p4153_직각삼각형.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            if (list.stream().allMatch(value -> value == 0)) break;

            int max = list.stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(0);

            int sum = list.stream()
                    .filter(value -> value != max)
                    .mapToInt(value -> value * value)
                    .sum();

            if (sum == max * max) System.out.println("right");
            else System.out.println("wrong");
        }

    }
}
