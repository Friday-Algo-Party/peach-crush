package class4.p9935_문자열폭발.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int strLen = str.length();
        int bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strLen; i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= bombLen) {
                boolean isBomb = true;

                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                    }
                }

                if (isBomb) sb.delete(sb.length() - bombLen, sb.length());
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
