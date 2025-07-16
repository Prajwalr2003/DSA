import java.util.*;

class DetectCycleUsingDFS {
    public static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node]=true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                if(dfs(it, node, adj, vis)) return true;
            }
            else if(it != parent){
                return true;
            }
        }

        return false;
    }

    public static boolean detectCycleUsingDFS(ArrayList<ArrayList<Integer>> adj, int N){
        boolean vis[] = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(!vis[i]){
                if(dfs(i, -1, adj, vis)==true) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


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

        System.out.println(detectCycleUsingDFS(adj, N));
    }
}
