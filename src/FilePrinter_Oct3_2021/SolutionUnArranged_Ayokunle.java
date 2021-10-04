package FilePrinter_Oct3_2021;

import java.util.Arrays;
import java.util.HashMap;

class Node {
    String value;
    String path;
    HashMap<String, Node> children = new HashMap<>();

    Node(String value) {
        this.value = value;

    }

    Node(String value, String path) {
        this.value = value;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", path='" + path + '\'' +
                ", children=" + children +
                '}';
    }
}

public class SolutionUnArranged_Ayokunle {
    public static Node Tree = new Node(null);

    public static String tabSpacer(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("\t");

        }

        return sb.toString();
    }

    public static void printTree(Node n, int depth) {


        var keys = n.children.keySet();
        if (n.value != null) {
            System.out.println(tabSpacer(depth) +"-"+ n.value);
        }

        for (var key : keys) {
            var d = depth + 1;
            printTree(n.children.get(key), d);
        }


    }

    public static void addToTree(String[] inputs) {

        Arrays.stream(inputs).forEach((path) -> {
            String[] paths = path.split("\\/");
            Node t = Tree;
            StringBuilder prevBuilder = new StringBuilder();
            for (String p : paths) {
                boolean isFile = p.contains(".");
                var filePath = prevBuilder.isEmpty() ? p : prevBuilder.append("/" + p).toString();
                var prev = t.children.get(p);
                if (prev == null) {
                    var n = new Node(p, filePath);
                    t.children.put(p, n);
                    t = n;
                } else {
                    t = prev;
                }
                prevBuilder = new StringBuilder(filePath);
            }
        });

    }

    public static void main(String[] args) {

        String[] inputs = new String[]{
                "app/documents/rude",
                "app/documents/person",
                "She/She.png",
                "She.png"};


        addToTree(inputs);
        printTree(Tree, -1);


    }
}
