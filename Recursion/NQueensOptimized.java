import java.util.*;

class NQueensOptimized{
	static int cnt=0;
	public static void f(int col, char[][] board, List<List<Character>> nqueens, boolean[]left, boolean[]upper, boolean[]lower){
		if(col == board[0].length){
			cnt++;

			for(int i=0; i<nqueens.size(); i++){
				System.out.println(nqueens.get(i));
			}
			System.out.println();

			return;
		}

		for(int i=0; i<board.length; i++){
			if(left[i]==false && lower[i+col]==false && upper[board.length-1+col-i]==false){
				nqueens.get(i).set(col, 'Q');
				left[i] = true;
				lower[i+col]=true;
				upper[board.length-1+col-i]=true;
				f(col+1, board, nqueens, left, upper, lower);
				left[i]=false;
				lower[i+col]=false;
				upper[board.length-1+col-i]=false;
				nqueens.get(i).set(col, '.');
			}
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Character>> nqueens = new ArrayList<>();
		char board[][] = new char[n][n];
		boolean left[] = new boolean[n];
		boolean upper[] = new boolean[2*n-1];
		boolean lower[] = new boolean[2*n-1];

		for(int i=0; i<n; i++){
			List<Character> row = new ArrayList<>(Collections.nCopies(n, '.'));
			nqueens.add(row);
		}

		f(0, board, nqueens, left, upper, lower);
		
		System.out.println(cnt);
	}
}