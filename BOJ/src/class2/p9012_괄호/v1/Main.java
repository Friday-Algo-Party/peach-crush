package class2.p9012_괄호.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            char[] PS = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < PS.length; i++) {
                if (PS[i] == '(') stack.push(PS[i]);

                if (PS[i] == ')') {
                    if (!stack.isEmpty()) stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}
