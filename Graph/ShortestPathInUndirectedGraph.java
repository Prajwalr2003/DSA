import java.util.*;

class ShortestPathInUndirectedGraph {
    public static int[] shortestPath(int[][] edges,int V,int E,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<E; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int dist[] = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(src);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int it : adj.get(node)){
                if(dist[node]+1 < dist[it]){
                    dist[it] = dist[node]+1;
                    q.offer(it);
                }   
            }
        }

        for(int i=0; i<V; i++){
            if(dist[i] == (int)1e9){
                dist[i]= -1;
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int edges[][] = new int[E][2];
        for(int i=0; i<E; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        int src = sc.nextInt();

        System.out.println(Arrays.toString(shortestPath(edges, V, E, src)));
    }
}