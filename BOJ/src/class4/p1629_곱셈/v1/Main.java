package class4.p1629_곱셈.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(B));
    }

    static long pow(long n) {
        if(n == 1) return A % C;

        long x = pow(n / 2);
        long result = x * x % C;

        if(n % 2 == 0) return result;
        return result * A % C;
    }
}
