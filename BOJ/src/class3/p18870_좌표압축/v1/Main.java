package class3.p18870_좌표압축.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        X[] arr = new X[N];

        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            arr[i] = new X(i, v);
        }

        Arrays.sort(arr);
        int[] result = new int[N];

        int prev = arr[0].value;
        result[arr[0].idx] = 0;

        int cnt = 0;

        for (int i = 1; i < N; i++) {
            X x = arr[i];
            if (x.value > prev) cnt++;
            result[x.idx] = cnt;
            prev = x.value;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}

class X implements Comparable<X> {
    int idx;
    int value;

    public X(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public int compareTo(X o) {
        return Integer.compare(value, o.value);
    }
}
