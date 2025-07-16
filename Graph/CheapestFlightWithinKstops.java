import java.util.*;

class CheapestFlightWithinKstops {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public static int cheapestFLight(int n,int flights[][],int src,int dst,int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i=0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            
            adj.get(u).add(new Pair(v, wt));
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});
        
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int stops = curr[0], node=curr[1], cost=curr[2];
            if(stops > k) continue;
            
            for(Pair p : adj.get(node)){
                int adjNode = p.first;
                int wt = p.second;
                
                if(wt+cost < dist[adjNode] && stops<=k){
                    dist[adjNode] = wt+cost;
                    q.offer(new int[]{stops+1, adjNode, dist[adjNode]});
                }
            }
        }
        
        return dist[dst]!=Integer.MAX_VALUE ? dist[dst] : -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int row = sc.nextInt(); 

        int[][] flights = new int[row][3];
        for(int i=0; i<row; i++){
            flights[i][0] = sc.nextInt();
            flights[i][1] = sc.nextInt();
            flights[i][2] = sc.nextInt();
        }

        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();


        int cheapestFlight = cheapestFLight(V, flights, src, dst, k);
        System.out.println(cheapestFlight);

        // 4 5 
        // 0 1 100 
        // 1 2 100
        // 2 0 100 
        // 1 3 600
        // 2 3 200
        // 0
        // 3
        // 1
    }
}