import java.util.*;

class PrintShortestPath {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public static List<Integer> shortestPath(int V, ArrayList<ArrayList<Pair>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.first != p2.first){
                    return Integer.compare(p1.first, p2.first);
                }

                return Integer.compare(p1.second, p2.second);
            }
        });

        pq.add(new Pair(0, 1));

        int dist[] = new int[V+1];
        Arrays.fill(dist, (int)1e8);
        dist[1] = 0;

        int parent[] = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i]=i;
        }

        while(!pq.isEmpty()){
            int wt = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int adjWt = it.second;

                if(adjWt+wt < dist[adjNode]){
                    dist[adjNode] = adjWt+wt;
                    parent[adjNode] = node;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        if(dist[V] == (int)1e8){
            return Arrays.asList(-1);
        }

        List<Integer> path = new ArrayList<>();

        int node = V;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }

        path.add(1);

        Collections.reverse(path);

        return path;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); 

        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i<M; i++){
            int u=sc.nextInt(), v=sc.nextInt(), wt=sc.nextInt();
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        for(int i=1; i<=N; i++){
            for(Pair it : adj.get(i)){
                System.out.print("{"+it.first+","+it.second+"}"+" ");
            }
            System.out.println();
        }

        List<Integer> path = shortestPath(N, adj);
        System.out.println(path);
    }
}