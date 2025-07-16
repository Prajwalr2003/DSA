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


class MaxConnectionDSU {
    public static boolean isValid(int nrow, int ncol, int n){
        return nrow>=0 && nrow<n && ncol>=0 && ncol<n;
    }
    public static int maxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        
        // Step 1 - Making all 1's connected using DSU
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col] == 0) continue;
                int drow[] = {-1, 0, +1, 0};
                int dcol[] = {0, +1, 0, -1};
                for(int idx=0; idx<4; idx++){
                    int nrow = row+drow[idx];
                    int ncol = col+dcol[idx];
                    
                    if(isValid(nrow, ncol, n) && grid[nrow][ncol]==1){
                        int node = row*n+col;
                        int adjNode = nrow*n+ncol;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }
        
        // Step 2 - Calculating size of each conn compo
        int max=0;
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col]==1) continue;
                int drow[] = {-1, 0, +1, 0};
                int dcol[] = {0, +1, 0, -1};
                Set<Integer> compo = new HashSet<>();
                
                for(int idx=0; idx<4; idx++){
                    int nrow=row+drow[idx];
                    int ncol=col+dcol[idx];
                    
                    if(isValid(nrow, ncol, n) && grid[nrow][ncol]==1){
                        int adjNode = nrow*n+ncol;
                        compo.add(ds.findUPar(adjNode));
                    }
                }
                
                int sum=0;
                for(int it : compo){
                    sum+=ds.size.get(it);
                }
                
                max = Math.max(max, sum+1);
            }
        }
        
        // Step 3 - If all are 1
        for(int i=0; i<n*n; i++){
            max = Math.max(max, ds.size.get(ds.findUPar(i)));
        }
        
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxConnection(grid));

        // 2
        // 1 1
        // 0 1
    }
}