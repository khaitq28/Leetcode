package daily;


import java.util.HashMap;
import java.util.Map;

public class ExpressionTreeEquivalence {

    public static void main(String[] args) {

    }

    boolean isEquivalence(Node node1, Node node2) {
        HashMap<Character, Integer> s1 = new HashMap<>();
        HashMap<Character, Integer> s2 = new HashMap<>();
        get(node1, s1);
        get(node2, s2);

        return s1.equals(s2);
    }

    private void get(Node node1, Map<Character, Integer> s) {
        if (node1 == null) {
            return ;
        }
        if (node1.left == null && node1.right == null) {
            s.put(node1.val, s.getOrDefault(node1.val, 0) + 1);
            return;
        }
        get(node1.left, s);
        get(node1.right, s);
    }

    class Node {
      char val;
      Node left;
      Node right;
      Node() {this.val = ' ';}
      Node(char val) { this.val = val; }
      Node(char val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
