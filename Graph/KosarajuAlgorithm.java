import java.util.*;

class KosarajuAlgorithm {

    private static void dfs(int node, boolean[] vis, 
    Stack<Integer> stk, ArrayList<ArrayList<Integer>> adj )
    {
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, stk, adj);
            }
        }
        stk.push(node);
    }

    private static void dfs2(int node, boolean[] vis, 
        ArrayList<ArrayList<Integer>> adjRev, List<Integer> list )
    {
        vis[node] = true;
        list.add(node);
        for(int it : adjRev.get(node)){
            if(!vis[it]){
                dfs2(it, vis, adjRev, list);
            }
        }
    }

    public static int stronglyConnectedComponents(
        ArrayList<ArrayList<Integer>> adj )
    {
        int V = adj.size();
        Stack<Integer> stk = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, vis, stk, adj);
            }
        }

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjRev.add(new ArrayList<>());
        }

        for(int i=0; i<V; i++){
            vis[i]=false;
            for(int it: adj.get(i)){
                adjRev.get(it).add(i);
            }
        }

        List<List<Integer>> scc = new ArrayList<>();

        int sccCnt=0;
        while(!stk.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int node = stk.pop();
            if(!vis[node]){
                sccCnt++;
                dfs2(node, vis, adjRev, list);
            }

            if(list.size()>0){
                scc.add(list);
            }
        }

        System.out.println(scc);

        return sccCnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            adj.get(sc.nextInt()).add(sc.nextInt());
        }

        System.out.println(stronglyConnectedComponents(adj));

        // 5 5
        // 1 0
        // 0 2
        // 2 1
        // 0 3
        // 3 4

        sc.close();
    }
}