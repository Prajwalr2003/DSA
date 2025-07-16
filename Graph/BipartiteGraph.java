import java.util.*;

class BipartiteGraph {
    public static boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, int[] colors){
        colors[src] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(src);
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(colors[it] == -1){
                    colors[it] = colors[node]==0 ? 1 : 0;
                    q.offer(it);
                }
                else if( colors[it] == colors[node]){
                    return false;
                }
            }
        }
        
        return true;
    }
    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        for(int i=0; i<V; i++){
            if(colors[i]==-1){
                if(bfs(i, adj, colors)==false) return false;
            }
        }
        return true;
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
            adj.get(v).add(u);
        }

        System.out.println(isBipartite(adj));
    }
}
