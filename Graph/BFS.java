import java.util.*;

class BFS {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int N){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[N+1];
        q.offer(1);
        vis[1]=true;

        while(!q.isEmpty()){
            int node=q.poll();
            ArrayList<Integer> nodes = adj.get(node);
            for(int j=0; j<nodes.size(); j++){
                if(!vis[nodes.get(j)]){
                    q.offer(nodes.get(j));
                    vis[nodes.get(j)]=true;
                }
            }
            bfs.add(node);
        } 

        return bfs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 5
        int M = sc.nextInt(); // 6

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            int u=sc.nextInt(), v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        } 
        ArrayList<Integer> bfs = bfs(adj, N);
        System.out.println(bfs);
    }
}
