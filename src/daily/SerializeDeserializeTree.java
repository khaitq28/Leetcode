package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 22/05/2024
 */

public class SerializeDeserializeTree {

    public static void main(String[] args) {

        SerializeDeserializeTree main = new SerializeDeserializeTree();
        Node n = main.deserialize("1,2,#,3,6,#,7,11,14,#,#,#,#,4,8,12,#,#,#,5,9,13,#,#,10,#,#,#,");

        System.out.println(n);
    }

    public Node deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] arr = data.split(",");
        Node x = new Node(-1);
        restore(arr, x);
        return x.child.get(0);
    }

    private Node restore(String[] arr, Node parent) {
        int val = Integer.parseInt(arr[i]);
        Node cur = new Node(val);
        parent.child.add(cur);
        i++;
        while (i < arr.length ) {
            if (arr[i].equals("#")) {
                i++;
                return parent;
            }
            restore(arr, cur);
        }
        return parent;
    }

    private int i = 0;

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.length() > 1 ? sb.deleteCharAt(sb.length()-1).toString(): "";
    }

    private void serialize(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        if (root.child.size() > 0) {
            for (Node child : root.child) {
                serialize(child, sb);
            }
        } else {
            sb.append("#,");
        }
    }
    static class Node {
        int val;
        List<Node> child;

        public Node(int val, List<Node>child) {
            this.val = val;
            this.child = child;
        }
        public Node(int val ) {
            this.val = val;
            this.child = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", child=" + child +
                    '}';
        }
    }

}
