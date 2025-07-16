import java.util.*;

class NumOfWaysToArriveAtDestination {
    static class Pair{
        int first;
        long second;
        public Pair(int first, long second){
            this.first = first;
            this.second = second;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(List<Integer> it : roads){
            adj.get(it.get(0)).add(new Pair(it.get(1), it.get(2)));
            adj.get(it.get(1)).add(new Pair(it.get(0), it.get(2)));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.second, b.second));
        
        pq.offer(new Pair(0, 0));
        
        long dist[] = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        int ways[] = new int[n];
        ways[0] = 1;
        
        int mod = (int)(1e9+7);
        
        while(!pq.isEmpty()){
            long cost = pq.peek().second;
            int node = pq.peek().first;
            pq.poll();
            
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                long wt = it.second;
                
                if(cost+wt < dist[adjNode]){
                    dist[adjNode] = cost+wt;
                    pq.offer(new Pair(adjNode, cost+wt));
                    ways[adjNode] = ways[node];
                }
                else if(cost+wt == dist[adjNode]){
                    ways[adjNode] = (ways[node]+ways[adjNode])%mod;
                }
            }
        }
        
        return ways[n-1]%mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V=sc.nextInt();
        int n = sc.nextInt();
        List<List<Integer>> roads = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++){
            List<Integer> road = new ArrayList<>(); 
            road.add(sc.nextInt());
            road.add(sc.nextInt());
            road.add(sc.nextInt());
            roads.add(road);
        }
        System.out.println(countPaths(V, roads));
        // 7 10
        // 0 6 7 
        // 0 1 2
        // 1 2 3
        // 1 3 3
        // 6 3 3
        // 3 5 1
        // 6 5 1 
        // 2 5 1
        // 0 4 5 
        // 4 6 2
    }
}