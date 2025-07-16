import java.util.*;

class FloydWarshallAlgorithm {
    public static void shortestDistance(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == -1){
                    mat[i][j] = (int)1e8;
                }
                if(i == j) mat[i][j] = 0;
            }
        }
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                }
            }
        }

        for(int i=0; i<n; i++){
            if(mat[i][j] == (int)1e8){
                System.out.println("Negative cycle exists");
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == (int)1e8){
                    mat[i][j] = -1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        shortestDistance(mat);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        
        // 2
        // 0 25
        // -1 0
    }
}