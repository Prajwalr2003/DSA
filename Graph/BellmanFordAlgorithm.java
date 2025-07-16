import java.util.*;

class BellmanFordAlgorithm {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        for(int i=0; i<V-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }
        
        return dist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int rows = sc.nextInt();
        int edges[][] = new int[rows][3];
        for(int i=0; i<rows; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        int src = sc.nextInt();

        System.out.println(Arrays.toString(bellmanFord(V, edges, src)));
        // 2 1
        // 0 1 9
        // 0
    }
}