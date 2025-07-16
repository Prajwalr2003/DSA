import java.util.*;

class NQueens{
	public static boolean possible(int rows, int cols, char[][] board, List<List<Character>> nqueens){
		int row = rows;
		int col = cols;
		// Upper Diagonal
		while(row>=0 && col>=0){
			if(nqueens.get(row).get(col) == 'Q'){
				return false;
			}
			row--;
			col--;
		}

		row=rows;
		col=cols;
		// Lower Diagonal
		while(row<=board.length-1 && col>=0){
			if(nqueens.get(row).get(col)=='Q'){
				return false;
			}
			row++;
			col--;
		}

		row=rows;
		col=cols;
		// Left 
		while(col>= 0){
			if(nqueens.get(row).get(col)=='Q'){
				return false;
			}
			col--;
		}

		return true;
	}

	public static void f(int col, char[][] board, List<List<Character>> nqueens){
		if(col == board[0].length){

			for(int i=0; i<nqueens.size(); i++){
				System.out.println(nqueens.get(i));
			}
			System.out.println();

			return;
		}

		for(int i=0; i<board.length; i++){
			if(possible(i, col, board, nqueens)){
				nqueens.get(i).set(col, 'Q');
				f(col+1, board, nqueens);
				nqueens.get(i).set(col, '.');
			}
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Character>> nqueens = new ArrayList<>();
		char board[][] = new char[n][n];

		for(int i=0; i<n; i++){
			List<Character> row = new ArrayList<>(Collections.nCopies(n, '.'));
			nqueens.add(row);
		}

		f(0, board, nqueens);
	}
}