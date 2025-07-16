import java.util.ArrayList;
import java.util.Stack;

public class PostorderUsingStack {
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

  // Using 2 stacks
  public static ArrayList<Integer> iterativePostorder(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> stk1 = new Stack<>();
    Stack<Node> stk2 = new Stack<>();
    stk1.push(root);
    while (!stk1.isEmpty()) {
      root = stk1.pop();
      stk2.push(root);
      if (root.left != null)
        stk1.push(root.left);
      if (root.right != null)
        stk1.push(root.right);
    }
    while (!stk2.isEmpty()) {
      list.add(stk2.pop().data);
    }
    return list;
  }

  // Using 1 stack only
  public static ArrayList<Integer> iterativePostorder2(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Node> stk = new Stack<>();
    Node curr = root;
    while (curr != null || !stk.isEmpty()) {
      if (curr != null) {
        stk.push(curr);
        curr = curr.left;
      } else {
        Node temp = stk.peek().right;
        if (temp == null) {
          temp = stk.pop();
          list.add(temp.data);
          while (!stk.isEmpty() && temp == stk.peek().right) {
            temp = stk.pop();
            list.add(temp.data);
          }
        } else {
          curr = temp;
        }
      }
    }
    return list;
  }

  public static void main(String args[]) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    System.out.println(iterativePostorder2(root));
  }
}
