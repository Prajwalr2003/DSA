import java.util.*;

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

class Edge implements Comparable<Edge>{
    int src, dest, wt;
    public Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    
    @Override
    public int compareTo(Edge compareEdge){
        return this.wt - compareEdge.wt;
    }
}


class KruskalsAlgorithm {
    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0; i<V; i++){
            for(int[] it : adj.get(i)){
                int v = it[0];
                int w = it[1];
                
                edges.add(new Edge(i, v, w));
            }
        }
        
        DisjointSet ds = new DisjointSet(V);
        
        Collections.sort(edges);
        
        int mstWt = 0;
        
        for(int i=0; i<edges.size(); i++){
            Edge e = edges.get(i);
            int u = e.src, v = e.dest, w = e.wt;
            if(ds.findUPar(u) != ds.findUPar(v)){
                mstWt += w;
                ds.unionByRank(u, v);
            }
        }
        
        return mstWt;
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