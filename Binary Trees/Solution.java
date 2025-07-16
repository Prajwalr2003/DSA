import java.util.*;
class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}
public class Solution {
    public static TreeNode bfs(Integer arr[]){
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.offer(root);
        int ind=1;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(ind<arr.length && arr[ind]!=null){
                TreeNode leftNode = new TreeNode(arr[ind]);
                curr.left = leftNode;
                q.offer(leftNode);
            }
            ind++;

            if(ind<arr.length && arr[ind]!=null){
                TreeNode rightNode = new TreeNode(arr[ind]);
                curr.right = rightNode;
                q.offer(rightNode);
            }
            ind++;
        }

        return root;
    }
    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void preorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(TreeNode root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void printBFS(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode curr = q.poll();
                System.out.print(curr.data+" ");
                if(curr.left != null) q.offer(curr.left);

                if(curr.right != null) q.offer(curr.right);

            }

            System.out.println();
        }
    }
    public static void iterativePreorder(TreeNode root){
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode curr = stk.pop();
            System.out.print(curr.data+" ");
            if(curr.right != null) stk.push(curr.right);
            if(curr.left != null) stk.push(curr.left);
        }
    }
    public static void iterativeInorder(TreeNode root){
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                stk.push(node);
                node = node.left;
            }
            else{
                if(stk.isEmpty()) break;
                node = stk.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }
        }
    }
    public static void iterativePostorder(TreeNode root){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode curr = s1.pop();
            s2.push(curr);
            if(curr.left!=null) s1.push(curr.left);
            if(curr.right!=null) s1.push(curr.right);
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().data+" ");
        }
    }
    public static void iterativePostorder2(TreeNode root){
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;

        while(curr!=null || !stk.isEmpty()){
            if(curr != null){
                stk.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = stk.peek().right;
                if(temp==null){
                    temp = stk.pop();
                    System.out.print(temp.data+" ");
                    while(!stk.isEmpty() && temp==stk.peek().right){
                        temp = stk.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
    }
    public static void allTraversal(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair<TreeNode, Integer>> stk = new Stack<>();
        stk.push(new Pair(root, 1));

        while(!stk.isEmpty()){
            Pair p = stk.peek();
            TreeNode curr = p.node;
            int num = p.num;
            if(num == 1){
                preorder.add(curr.data);
                p.num++;
                if(curr.left!=null) stk.push(new Pair(curr.left, 1));
            }
            else if(num == 2){
                inorder.add(curr.data);
                p.num++;
                if(curr.right!=null) stk.push(new Pair(curr.right, 1));
            }
            else{
                postorder.add(curr.data);
                stk.pop();
            }
        }

        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        Integer[] arr = new Integer[str.length];
        for(int i=0; i<str.length; i++){
            if(!str[i].equals("null")){
                arr[i] = Integer.parseInt(str[i]);
            }else{
                arr[i] = null;
            }
        }

        TreeNode root = bfs(arr);

        iterativePostorder2(root);
    }
}

// TC = 1 2 7 3 4 null null null null 5 6