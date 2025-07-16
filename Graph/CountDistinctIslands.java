import java.util.*;

class CountDistinctIslands {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;

            if(obj==null || getClass() != obj.getClass()) return false;

            Pair pair = (Pair) obj;

            return first==pair.first && second==pair.second;
        }

        @Override
        public int hashCode(){
            return Objects.hash(first,second);
        }
    }

    public static void bfs(int r, int c, int[][] grid, boolean[][] vis, Set<List<Pair>> patterns){

        int n = grid.length;
        int m = grid[0].length;

        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(r, c));

        List<Pair> shape = new ArrayList<>();
        shape.add(new Pair(0, 0));

        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            for(int i=0; i<4; i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                !vis[nrow][ncol] && grid[nrow][ncol]==1){
                    vis[nrow][ncol] = true;
                    shape.add(new Pair(nrow-r, ncol-c));
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        patterns.add(shape);
    }

    public static int countDistinctIslands(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        Set<List<Pair>> patterns = new HashSet<List<Pair>>();
        boolean vis[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    bfs(i, j, grid, vis, patterns);
                }
            }
        }

        return patterns.size();
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

        System.out.println(countDistinctIslands(grid));
    }
}
