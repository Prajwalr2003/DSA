import java.util.*;

class Solution {

    public static boolean dfs(int node, List<List<Integer>> adjList, boolean[] vis, boolean[] pathVis,
    boolean[] check){
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for(int adjNode : adjList.get(node)){
            if(!vis[adjNode]){
                if(dfs(adjNode, adjList, vis, pathVis, check)) return true;
            }else if(pathVis[adjNode]){
                return true;
            }
        }

        check[node] = true;
        pathVis[node] = false;

        return false;
    }

    public static List<Integer> f(List<List<Integer>> adjList, int V) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];

        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adjList, vis, pathVis, check);
            }
        }

        for(int i=0; i<V; i++){
            if(check[i]){
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            int u = sc.nextInt(), v = sc.nextInt();
            adjList.get(u).add(v);
        }

        System.out.println(f(adjList, V));

        // for(int i=0; i<V; i++){
        //     System.out.println(i+" "+adjList.get(i));
        // }
    }
}
