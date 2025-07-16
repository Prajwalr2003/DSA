import java.util.*;

class GraphIntro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 5
        int M = sc.nextInt(); // 6

        // Input will give us No. of nodes and edges
        // N=5, M=6
        // Those M Lines Represent All the Edges
        // 1 2
        // 1 3
        // 3 4
        // 2 4
        // 2 5
        // 4 5

        // Store 1) Matrix 2) List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            int u=sc.nextInt(), v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=1; i<=N; i++){
            System.out.println(adj.get(i));
        }

        // For weighted graph we need to store the weight
        // in pair with the edges
    }
}
