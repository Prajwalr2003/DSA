import java.util.*;

class PrerequisitesTask {
    public static boolean isPossible(int N,int P, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0; i<P; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int indegree[] = new int[N];
        for(int i=0; i<N; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        List<Integer> topoSort = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
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
        
        if(topoSort.size() == N) return true;
        
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();

        int[][] prerequisites = new int[P][2];
        for(int i=0 ;i<P; i++){
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }

        System.out.println(isPossible(N, P, prerequisites));

        // 4
        // 3
        // 1 0
        // 2 1
        // 3 2
    }
}
