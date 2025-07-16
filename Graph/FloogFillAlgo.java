import java.util.*;

class FloogFillAlgo {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int N = sc.nextInt();
    //     int M = sc.nextInt();


    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    //     for(int i=0; i<=N; i++){
    //         adj.add(new ArrayList<Integer>());
    //     }

    //     for(int i=0; i<M; i++){
    //         int u=sc.nextInt(), v=sc.nextInt();
    //         adj.get(u).add(v);
    //         adj.get(v).add(u);
    //     } 

    //     for(int i=1; i<=N; i++){
    //         System.out.println(adj.get(i));
    //     }
    // }

    public static void dfs(int row, int col, int[][] image, int newColor, int iniColor, int[] delRow, int[] delCol){
        int n=image.length;
        int m=image[0].length;
        image[row][col] = newColor;

        for(int i=0; i<4; i++){
            int nrow = row+delRow[i];
            int ncol = col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && image[nrow][ncol]!=newColor){
                dfs(nrow, ncol, image, newColor, iniColor, delRow, delCol);
            }
        }
    }

    public static void floodFillAgo(int[][] image, int sr, int sc, int newColor, int iniColor){
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        dfs(sr, sc, image, newColor, iniColor, delRow, delCol);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int image[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                image[i][j] = scanner.nextInt();
            }
        }

        int sr = scanner.nextInt();
        int sc = scanner.nextInt();
        int newColor = scanner.nextInt();
        int iniColor = image[sr][sc];

        floodFillAgo(image, sr, sc, newColor, iniColor);

        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
