package class4.p11054_가장긴바이토닉부분수열.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N + 2];
        int[] increase = new int[N + 1];
        int[] decrease = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    increase[i] = Math.max(increase[i], increase[j] + 1);
                }
            }
        }

        for (int i = N; i > 0; i--) {
            for (int j = i + 1; j <= N + 1; j++) {
                if (nums[i] > nums[j]) {
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
                }
            }
        }

        int result = 0;

        for (int i = 0; i <= N; i++) {
            result = Math.max(result, increase[i] + decrease[i]);
        }

        System.out.println(result - 1);
    }
}
