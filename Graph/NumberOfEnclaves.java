import java.util.*;

class NumberOfEnclaves {

    public static void dfs(int row, int col, int[][] grid, int n, int m, boolean[][] vis){
        vis[row][col] = true;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
            !vis[nrow][ncol] && grid[nrow][ncol]==1){
                dfs(nrow, ncol, grid, n, m, vis);
            }
        }
    }

    public static int numberOfEnclaves(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        for(int j=0; j<m; j++){
            if(!vis[0][j] && grid[0][j]==1){
                dfs(0, j, grid, n, m, vis);
            }

            if(!vis[n-1][j] && grid[n-1][j]==1){
                dfs(n-1, j, grid, n, m, vis);
            }
        }

        for(int i=0; i<n; i++){
            if(!vis[i][0] && grid[i][0]==1){
                dfs(i, 0, grid, n, m, vis);
            }

            if(!vis[i][m-1] && grid[i][m-1]==1){
                dfs(i, m-1, grid, n, m, vis);
            }
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    cnt++;
                }
            }
        }

        return cnt;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int grid[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = numberOfEnclaves(grid);
        System.out.println(ans);
    }
}
