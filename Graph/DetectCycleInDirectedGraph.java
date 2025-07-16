import java.util.*;

class DetectCycleInDirectedGraph {
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 2;
        
        for(int it : adj.get(node)){
            if(vis[it]==0){
                if(dfs(it, adj, vis)) return true;
            }
            else if(vis[it]==2){
                return true;
            }
        }

        vis[node] = 1;
        return false;
    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                if(dfs(i, adj, vis)) return true;
            }
        }

        return false;
        
    }
    // public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis){
    //     vis[node] = 1;
    //     pathVis[node] = 1;

    //     for(int it : adj.get(node)){
    //         if(vis[it]==0){
    //             if(dfs(it, adj, vis, pathVis)) return true;
    //         }
    //         else if(pathVis[it]==1){
    //             return true;
    //         }
    //     }

    //     pathVis[node] = 0;
    //     return false;
    // }
    // public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
    //     int vis[] = new int[V];
    //     int pathVis[] = new int[V];
    //     for(int i=0; i<V; i++){
    //         if(vis[i]==0){
    //             if(dfs(i, adj, vis, pathVis)) return true;
    //         }
    //     }

    //     return false;
    // }
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
            adj.get(v).add(u);
        }

        System.out.println(isCycle(N, adj));
    }
}
