import java.util.*;

class DetectCycleUsingBFS {

    static class Pair{
        int node;
        int parent;
        public Pair(int node, int parent){
            this.node=node;
            this.parent=parent;
        }
    }

    public static boolean detect(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<Pair> q = new LinkedList<Pair>();
        vis[src]=true;
        q.offer(new Pair(src, -1));
        while(!q.isEmpty()){
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();

            for(int it : adj.get(node)){
                if(!vis[it]){
                    q.offer(new Pair(it, node));
                    vis[it]=true;
                }
                else if(parent != it){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUsingBFS(ArrayList<ArrayList<Integer>> adj, int N){
        boolean vis[] = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(!vis[i]){
                if(detect(i, adj, vis)==true) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            int u=sc.nextInt(), v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        } 

        for(int i=1; i<=N; i++){
            System.out.println(adj.get(i));
        }

        System.out.println(detectCycleUsingBFS(adj, N));
    }
}
