import java.util.*;

class ShortestDistanceInBinaryMaze {
    public static int shortestDistance(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]){
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        
        for(int i=0; i<n; i++){
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }
        
        vis[source[0]][source[1]] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, source[0], source[1]});
        
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            int distance = p[0], row=p[1], col=p[2];
            
            for(int i=0; i<4; i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                grid[nrow][ncol] != 0 && distance+1 < vis[nrow][ncol]){
                    vis[nrow][ncol] = distance+1;
                    if(nrow==destination[0] && ncol==destination[1]){
                        return distance+1;
                    }
                    q.offer(new int[]{distance+1, nrow, ncol});
                }
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); 

        int grid[][] = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int source[] = new int[2];
        source[0] = sc.nextInt();
        source[1] = sc.nextInt();

        int destination[] = new int[2];
        destination[0] = sc.nextInt();
        destination[1] = sc.nextInt();

        int dist = shortestDistance(grid, source, destination);
        System.out.println(dist);

        // 5 4
        // 1 1 1 1
        // 1 1 0 1
        // 1 1 1 1
        // 1 1 0 0
        // 1 0 0 1
        // 0 1
        // 2 2
    }
}