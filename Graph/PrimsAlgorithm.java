import java.util.*;

class PrimsAlgorithm {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.offer(new int[]{0, 0, -1});
        
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);

        List<Pair> MST = new ArrayList<>();
        
        int sum=0;
        
        while(!pq.isEmpty()){
            int cost = pq.peek()[0];
            int node = pq.peek()[1];
            int parent = pq.peek()[2];
            
            pq.poll();
            
            if(vis[node]) continue;
            
            vis[node] = true;
            sum+=cost;

            if(parent!=-1){
                MST.add(new Pair(parent, node));
            }
            
            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int wt = it[1];
                if(!vis[adjNode]){
                    pq.add(new int[]{wt, adjNode, node});
                }
            }
        }

        for(int i=0; i<MST.size(); i++){
            System.out.print("("+MST.get(i).first+" "+MST.get(i).second+")");
        }
        System.out.println();
        
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            int u=sc.nextInt(), v=sc.nextInt(), wt=sc.nextInt();
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        System.out.println(spanningTree(V, E, adj));

        // 3 3
        // 0 1 5
        // 1 2 3
        // 0 2 1
    }
}
