package class4.p1991_트리순회.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            nodes[value - 'A'] = new Node(left, right);
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');

        System.out.println(sb);
    }

    static void preorder(char c) {
        Node node = nodes[c - 'A'];
        sb.append(c);
        if(node.left != '.') preorder(node.left);
        if(node.right != '.') preorder(node.right);
    }

    static void inorder(char c) {
        Node node = nodes[c - 'A'];
        if(node.left != '.') inorder(node.left);
        sb.append(c);
        if(node.right != '.') inorder(node.right);
    }

    static void postorder(char c) {
        Node node = nodes[c - 'A'];
        if(node.left != '.') postorder(node.left);
        if(node.right != '.') postorder(node.right);
        sb.append(c);
    }
}

class Node {
    char left;
    char right;

    public Node(char left, char right) {
        this.left = left;
        this.right = right;
    }
}
