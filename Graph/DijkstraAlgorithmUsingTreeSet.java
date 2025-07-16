import java.util.*;

class DijkstraAlgorithmUsingTreeSet {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public static ArrayList<Integer> shortestPath(ArrayList<ArrayList<Pair>> adj, int src){
        TreeSet<Pair> set = new TreeSet<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.first!=p2.first){
                    return Integer.compare(p1.first, p2.first);
                }
                return Integer.compare(p1.second, p2.second);
            }
        });

        set.add(new Pair(0, src));
        int V = adj.size();

        ArrayList<Integer> dist = new ArrayList<>(V);
        for(int i=0; i<V; i++){
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(src, 0);

        while(!set.isEmpty()){
            Pair p = set.pollFirst();
            int wt = p.first;
            int node = p.second;

            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int d = it.second;
                if(dist.get(adjNode) > d+wt){
                    if(dist.get(adjNode) != Integer.MAX_VALUE){
                        set.remove(new Pair(dist.get(adjNode), adjNode));
                    }
                    dist.set(adjNode, wt+d);
                    set.add(new Pair(dist.get(adjNode), adjNode));
                }
            }
        }

        for(int i=0; i<V; i++){
            if(dist.get(i) == Integer.MAX_VALUE){
                dist.set(i, -1);
            }
        }

        return dist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); 

        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i<M; i++){
            int u=sc.nextInt(), v=sc.nextInt(), wt=sc.nextInt();
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        // for(int i=0; i<N; i++){
        //     for(Pair it : adj.get(i)){
        //         System.out.print("{"+it.first+","+it.second+"}"+" ");
        //     }
        //     System.out.println();
        // }

        ArrayList<Integer> path = shortestPath(adj, 0);
        System.out.println(path);
    }
}