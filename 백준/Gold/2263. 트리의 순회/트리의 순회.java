import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] in;
    static int[] post;
    static Map<Integer, Integer> inIndex = new HashMap<>();

    static Node buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = post[postEnd];
        int rootIndex = inIndex.get(rootValue);

        Node root = new Node(rootValue);
        root.left = buildTree(inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);
        root.right = buildTree(rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);

        return root;
    }

    static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            in[i] = Integer.parseInt(str[i]);
            inIndex.put(in[i], i);
        }

        String[] str2 = br.readLine().split(" ");
        for (int i = 0; i < str2.length; i++) {
            post[i] = Integer.parseInt(str2[i]);
        }

        Node root = buildTree(0, n - 1, 0, n - 1);
        printPreorder(root);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
