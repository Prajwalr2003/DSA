import java.util.*;

class RottenOranges {

    static class Pair{
        int first;
        int second;
        int time;
        public Pair(int first, int second, int time){
            this.first = first;
            this.second = second;
            this.time=time;
        }
    }

    public static int rottenOranges(int[][] grid, int n, int m){
        int vis[][] = new int[n][m];

        Queue<Pair> q = new LinkedList<Pair>();
        int tm=0, cntFresh=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i, j, tm));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }

                if(grid[i][j]==1) cntFresh++;
            }
        }

        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, -1, 0, +1};
        int cnt=0;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int time = q.peek().time;
            tm = Math.max(tm, time);
            q.poll();

            for(int i=0; i<4; i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow, ncol, tm+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if(cnt!=cntFresh) return -1;

        return tm;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int grid[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(rottenOranges(grid, n, m));
    }
}
