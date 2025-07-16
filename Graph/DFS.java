import java.util.*;

class DFS {
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> dfs){
        dfs.add(node);
        vis[node]=true;
        for(int it : adj.get(node)){
           if(!vis[it]){
            dfs(it, adj, vis, dfs);
           }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj, int N){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean vis[] = new boolean[N+1];
        int start=1;
        vis[start]=true; 
        dfs(start, adj, vis, dfs)
        return dfs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 5
        int M = sc.nextInt(); // 6

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

        
        ArrayList<Integer> dfs = dfsOfGraph(adj, N);
        System.out.println(dfs);
    }
}
