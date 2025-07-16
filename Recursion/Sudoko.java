import java.util.*;

class Sudoko{
	public static boolean possible(int row, int col, int k, int[][]board){
		for(int i=0; i<9; i++){
			if(board[row][i]==k) return false;
			if(board[i][col]==k) return false;
			if(board[3*(row/3)+i/3][3*(col/3)+col%3]==k) return false;
		}

		return true;
	}
	public static boolean f(int[][] board){
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(board[i][j]==0){
					for(int k=1; k<=9; k++){
						if(possible(i, j, k, board)){
							board[i][j]=k;
							if(f(board)==true) return true;
							else board[i][j]=0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[9][9];
		for(int i=0; i<9 ;i++){
			for(int j=0; j<9; j++){
				board[i][j]=sc.nextInt();
			}
		}
		f(board);
		for(int i=0; i<9 ;i++){
			for(int j=0; j<9; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}

	}
}