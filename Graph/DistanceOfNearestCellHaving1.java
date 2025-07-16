import java.util.*;

class DistanceOfNearestCellHaving1 {
    static class Pair{
        int row;
        int col;
        int distance;
        public Pair(int row, int col, int distance){
            this.row=row;
            this.col=col;
            this.distance=distance;
        }
    }
    public static void bfs(int[][] grid, int[][] vis, int[][] res){
        Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length;
        int m = grid[0].length;
        int distance=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    q.offer(new Pair(i, j, distance));
                    vis[i][j] = 1;
                    res[i][j] = 0;
                }
            }
        }

        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, -1, 0, +1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().distance;
            res[row][col] = dist;
            q.poll();

            for(int i=0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                vis[nrow][ncol]!=1 && grid[nrow][ncol]==0){
                    q.offer(new Pair(nrow, ncol, dist+1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
    public static int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int res[][] = new int[n][m];

        bfs(grid, vis, res);

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int grid[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int ans[][] = nearest(grid);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}
