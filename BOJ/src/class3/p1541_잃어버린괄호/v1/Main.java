package class3.p1541_잃어버린괄호.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] exps = br.readLine().split("-");

        int result = 0;

        result = getSum(exps[0]);

        for (int i = 1; i < exps.length; i++) {
            result -= getSum(exps[i]);
        }

        System.out.println(result);
    }

    private static int getSum(String exp) {
        int sum = 0;

        String[] nums = exp.split("\\+");

        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
