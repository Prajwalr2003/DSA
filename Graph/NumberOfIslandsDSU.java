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


class NumberOfIslandsDSU {
    public static boolean isValid(int nrow, int ncol, int n, int m, int[][] vis){
        return nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==1;
    }
    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators){
        int[][] vis = new int[rows][cols];
        for(int i=0; i<rows; i++){
            Arrays.fill(vis[i], 0);
        }

        List<Integer> ans = new ArrayList<>();
        int cnt=0;

        DisjointSet ds = new DisjointSet(rows*cols);
        for(int i=0; i<operators.length; i++){
            int row=operators[i][0];
            int col=operators[i][1];

            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;
            cnt++;

            int drow[] = {-1, 0, +1, 0};
            int dcol[] = {0, +1, 0, -1};

            for(int j=0; j<4; j++){
                int nrow = row+drow[j];
                int ncol = col+dcol[j];

                if(isValid(nrow, ncol, rows, cols, vis)){
                    int u = nrow*cols+ncol;
                    int v = row*cols+col;

                    if(ds.findUPar(u) != ds.findUPar(v)){
                        cnt--;
                        ds.unionBySize(u, v);
                    }
                }
            }

            ans.add(cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] operators = new int[k][2];
        for(int i=0; i<k; i++){
            operators[i][0] = sc.nextInt();
            operators[i][1] = sc.nextInt();
        }  

        System.out.println(numOfIslands(n, m, operators));

        // 4
        // 5
        // 4
        // 1 1
        // 0 1
        // 3 3
        // 3 4
    }
}