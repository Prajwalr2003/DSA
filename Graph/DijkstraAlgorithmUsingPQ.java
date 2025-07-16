import java.util.*;

class DijkstraAlgorithmUsingPQ {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public static ArrayList<Integer> shortestPath(ArrayList<ArrayList<Pair>> adj, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                if(p1.second != p2.second){
                    return Integer.compare(p1.second, p2.second);
                }

                return Integer.compare(p1.first, p2.first);
            }
        });
        pq.add(new Pair(src, 0));
        int V = adj.size();

        ArrayList<Integer> dist = new ArrayList<>(V);
        for(int i=0; i<V; i++){
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(src, 0);

        while(!pq.isEmpty()){
            int node = pq.peek().first;
            int wt = pq.peek().second;
            pq.remove();

            for(Pair it : adj.get(node)){
                if(dist.get(it.first) > it.second+wt){
                    dist.set(it.first, wt+it.second);
                    pq.add(new Pair(it.first, wt+it.second));
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

        for(int i=0; i<N; i++){
            for(Pair it : adj.get(i)){
                System.out.print("{"+it.first+","+it.second+"}"+" ");
            }
            System.out.println();
        }

        ArrayList<Integer> path = shortestPath(adj, 0);
        System.out.println(path);
    }
}