import java.util.*;

public class BFSTraversalTree {
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

  public static ArrayList<ArrayList<Integer>> BFSTraversal(Node root) {
    Queue<Node> queue = new LinkedList<>();
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      ArrayList<Integer> subList = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        if (queue.peek().left != null)
          queue.add(queue.peek().left);
        if (queue.peek().right != null)
          queue.add(queue.peek().right);
        subList.add(queue.remove().data);
      }
      list.add(subList);
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
    System.out.println(BFSTraversal(root));
  }
}