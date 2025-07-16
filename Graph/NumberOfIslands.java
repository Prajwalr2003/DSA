import java.util.*;

class NumberOfIslands {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    private static void bfs(int i, int j, char[][] grid, boolean[][] vis){
        vis[i][j] = true;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(i, j));
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            
            for(int delrow=-1; delrow<=1; delrow++){
                for(int delcol=-1; delcol<=1; delcol++){
                    int nrow=row+delrow;
                    int ncol=col+delcol;
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]=='1'){
                        vis[nrow][ncol]=true;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    public static int numIslands(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int cnt=0;
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(!vis[row][col] && grid[row][col]=='1'){
                    cnt++;
                    bfs(row, col, grid, vis);
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 5
        int m = sc.nextInt(); // 6
        sc.nextLine();

        char[][] grid = new char[n][m];
        for(int i=0 ;i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<m; j++){
                grid[i][j] = str.charAt(j);
            }
        }

        System.out.println(numIslands(grid));
    }
}
