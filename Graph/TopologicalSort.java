import java.util.*;

class TopologicalSort {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stk){
        vis[node]=true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, adj, vis, stk);
            }
        }
        stk.push(node);
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean vis[] = new boolean[V];
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> topoSort = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adj, vis, stk);
            }
        }

        while(!stk.isEmpty()){
            topoSort.add(stk.pop());
        }

        return topoSort;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int M = sc.nextInt(); 

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            int u=sc.nextInt(), v=sc.nextInt();
            adj.get(u).add(v);
        }

        ArrayList<Integer> res = topologicalSort(adj);
        System.out.println(res);
    }
}
