import java.util.ArrayList;
import java.util.Stack;

public class PreorderUsingStack {
  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static ArrayList<Integer> iterativeInorder(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> stk = new Stack<>();
    stk.push(root);
    while (!stk.isEmpty()) {
      root = stk.pop();
      list.add(root.data);
      if (root.right != null)
        stk.push(root.right);
      if (root.left != null)
        stk.push(root.left);
    }
    return list;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    System.out.println(iterativeInorder(root));
  }
}
