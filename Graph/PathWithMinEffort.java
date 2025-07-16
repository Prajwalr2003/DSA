import java.util.*;

class PathWithMinEffort {
    public static int minimumEffort(int rows, int columns, int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        
        pq.offer(new int[]{0, 0, 0});
        
        int vis[][] = new int[rows][columns];
        for(int i=0; i<rows; i++){
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }
        
        vis[0][0] = 0;
        
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = { 0, +1, 0, -1};
        int ans=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int diff = p[0], row=p[1], col=p[2];
            
            if(row == rows-1 && col==columns-1){
                return diff;
            }
            
            for(int i=0; i<4; i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<columns){
                    
                    int effort = Math.max(Math.abs(heights[nrow][ncol] - heights[row][col]), diff);
                    
                    if(effort < vis[nrow][ncol]){
                        vis[nrow][ncol] = effort;
                        pq.offer(new int[]{effort, nrow, ncol});
                    }
                }
            }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); 

        int heights[][] = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                heights[i][j] = sc.nextInt();
            }
        }

        int minEffort = minimumEffort(N, M, heights);
        System.out.println(minEffort);

        // 3
        // 3
        // 1 2 2
        // 3 8 2
        // 5 3 5
    }
}