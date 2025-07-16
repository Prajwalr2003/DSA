import java.util.*;

class Subsequence{
	public static void f(int i, int n, ArrayList<Integer> list, int arr[],ArrayList<ArrayList<Integer>> subsequences){
		if(i>=n){
			subsequences.add(new ArrayList<>(list));
			return;
		}
		list.add(arr[i]);
		f(i+1, n, list, arr, subsequences);
		list.remove(list.size()-1);
		f(i+1, n, list, arr, subsequences);
	} 

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> subsequences = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int arr[] = {3, 1, 2};
		f(0, 3, list, arr, subsequences);

		for(int i=0; i<subsequences.size(); i++){
			System.out.println(subsequences.get(i));
		}
	} 
}    