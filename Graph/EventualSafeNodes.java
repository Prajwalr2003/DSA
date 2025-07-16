import java.util.*;

class EventualSafeNodes {
    public static List<Integer> eventualSafeNodes2(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<V; i++){
            adjRev.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                adjRev.get(it).add(i);
            }
        }

        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();
        for(int i=0; i<V; i++){
            for(int it : adjRev.get(i)){
                indegree[it]++;
            }
        }

        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);

            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        Collections.sort(topoSort);

        return topoSort;

    }
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis, int mark[]){
        vis[node] = 1;
        pathVis[node] = 1;
        mark[node] = 0;
        
        for(int it : adj.get(node)){
            if(vis[it]==0){
                if(dfs(it, adj, vis, pathVis, mark)) return true;
            }
            else if(pathVis[it]==1){
                return true;
            }
        }
        
        mark[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    
    public static List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> adj) {

        // Your code here
        List<Integer> safeNodes = new ArrayList<>();
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int mark[] = new int[V];
        
        for(int i=0; i<V; i++){
            if(vis[i]==0){
                dfs(i, adj, vis, pathVis, mark);
            }
        }
        
        for(int i=0; i<V; i++){
            if(mark[i] == 1){
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
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

        List<Integer> list = eventualSafeNodes2(N, adj);
        System.out.println(list);
    }
}
