import java.util.*;

class ShortestPathInDAGUsingTopoSort {
    static class Pair{
        int node;
        int wt;
        public Pair(int node, int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    
    private static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean vis[], Stack<Integer> stk){
        vis[node] = true;
        
        for(Pair it : adj.get(node)){
            if(!vis[it.node]){
                topoSort(it.node, adj, vis, stk);
            }
        }
        
        stk.push(node);
    }

    public static int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i=0; i<edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(src).add(new Pair(des, wt));
        }
        
        Stack<Integer> stk = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                topoSort(i, adj, vis, stk);
            }
        }
        
        int dist[] = new int[V];
        Arrays.fill(dist, (int)1e6);
        dist[0] = 0;
        
        while(!stk.isEmpty()){
            int node = stk.pop();
            for(Pair it : adj.get(node)){
                int neighbor = it.node;
                int wt = it.wt;
                
                if(dist[node] + wt < dist[neighbor]){
                    dist[neighbor] = dist[node]+wt;
                }
            }
        }
        for(int i=0; i<dist.length; i++){
            if(dist[i] == (int)1e6){
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int matrix[][] = new int[E][3];
        for(int i=0; i<E; i++){
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
            matrix[i][2] = sc.nextInt(); 
        }

        int res[] = shortestPath(V, E, matrix);
        System.out.println(Arrays.toString(res));
    }
}