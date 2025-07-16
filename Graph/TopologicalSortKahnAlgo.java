import java.util.*;

class TopologicalSortKahnAlgo {

    public static List<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int V){
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }

        return topoSort;
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
        }

        List<Integer> res = topologicalSort(adj, N);
        System.out.println(res);
    }
}
