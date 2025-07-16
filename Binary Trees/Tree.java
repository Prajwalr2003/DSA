import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

class Pair {
    TreeNode node;
    int num;

    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void insert(int data) {
        TreeNode newTreeNode = new TreeNode(data);
        if (root == null) {
            root = newTreeNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left == null) {
                temp.left = newTreeNode;
                break;
            } else {
                queue.offer(temp.left);
            }

            if (temp.right == null) {
                temp.right = newTreeNode;
                break;
            } else {
                queue.offer(temp.right);
            }
        }
    }

    public void printInorder() {
        inorder(root);
    }

    public void printPreorder() {
        preorder(root);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode temp = stk.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stk.push(temp.right);
            }
            if (temp.left != null) {
                stk.push(temp.left);
            }
        }
    }

    public void allTraversal() {
        generateAllTraversal(root);
    }

    public void generateAllTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root, 1));

        while (!stk.isEmpty()) {
            Pair curr = stk.pop();
            if (curr.num == 1) {
                preOrder.add(curr.node.data);
                curr.num++;
                stk.push(curr);
                if (curr.node.left != null)
                    stk.push(new Pair(curr.node.left, 1));
            } else if (curr.num == 2) {
                inOrder.add(curr.node.data);
                curr.num++;
                stk.push(curr);
                if (curr.node.right != null) {
                    stk.push(new Pair(curr.node.right, 1));
                }
            } else {
                postOrder.add(curr.node.data);
            }
        }
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }
}

class Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        int nodes = sc.nextInt();
        for (int i = 0; i < nodes; i++) {
            tree.insert(sc.nextInt());
        }

        tree.allTraversal();
        sc.close();
    }
}
