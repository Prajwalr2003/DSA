import java.util.*;

class Solution {
    public static boolean isPossible(int row, int col, char[][] grid){
        int r=row, c=col;
        while(c>=0){
            if(grid[r][c] == 'Q') return false;
            c--;
        }

        r=row;
        c=col;
        while(r>=0 && c>=0){
            if(grid[r][c] == 'Q') return false;
            r--;
            c--;
        }

        r=row;
        c=col;
        while(r<grid.length && c>=0){
            if(grid[r][c] == 'Q') return false;
            r++;
            c--;
        }

        return true;
    }

    public static void nQueens(int col, int n, char[][] grid){
        if(col>=n){
            for(int i=0; i<n; i++){
                System.out.println(Arrays.toString(grid[i]));
            }
            System.out.println();
            return;
        }
        for(int row=0; row<n; row++){
            if(isPossible(row, col, grid)){
                grid[row][col] = 'Q';
                nQueens(col+1, n, grid);
                grid[row][col] = ' ';
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(grid[i], ' ');
        }

        nQueens(0, n, grid);
    }
}
