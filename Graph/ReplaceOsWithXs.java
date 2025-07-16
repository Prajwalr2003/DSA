import java.util.*;

class ReplaceOsWithXs {
    
    public static void dfs(int row, int col, boolean[][] vis, char[][] grid, int delrow[], int delcol[]){
        vis[row][col] = true;
        for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];

            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length &&
            !vis[nrow][ncol] && grid[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, grid, delrow, delcol);
            }
        }
    }
    public static char[][] replaceOsWithXs(char[][] grid, int n, int m){
        boolean vis[][] = new boolean[n][m];
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};
        for(int j=0; j<m; j++){
            if(!vis[0][j] && grid[0][j] == 'O'){
                dfs(0, j, vis, grid, delrow, delcol);
            }
            
            if(!vis[n-1][j] && grid[n-1][j] == 'O'){
                dfs(n-1, j, vis, grid, delrow, delcol);
            }
        }
        
        for(int i=0; i<n; i++){
            if(!vis[i][0] && grid[i][0] == 'O'){
                dfs(i, 0, vis, grid, delrow, delcol);
            }
            
            if(!vis[i][m-1] && grid[i][m-1] == 'O'){
                dfs(i, m-1, vis, grid, delrow, delcol);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]=='O'){
                    grid[i][j] = 'X';
                }
            }
        }

        return grid;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char grid[][] = new char[n][m];

        for(int i=0; i<n; i++){
            String[] str = sc.nextLine().split(" ");
            for(int j=0; j<m; j++){
                grid[i][j] = str[j].charAt(0);
            }
        }

        char ans[][] = replaceOsWithXs(grid, n, m);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}
