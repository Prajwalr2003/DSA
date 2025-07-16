import java.util.*;

class Permutation{

	public static void f(int[] arr, List<Integer> list, boolean[] freq, List<List<Integer>> permutations){
		if(list.size() == arr.length){
			permutations.add(new ArrayList<>(list));
			return;
		}

		for(int i=0; i<arr.length; i++){
			if(!freq[i]){
				freq[i]=true;
				list.add(arr[i]);
				f(arr, list, freq, permutations);
				list.remove(list.size()-1);
				freq[i]=false;
			}
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = {1, 2, 3};
		boolean freq[] = new boolean[arr.length];
		List<List<Integer>> permutations =  new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		f(arr, list, freq, permutations);

		for(int i=0 ; i<permutations.size(); i++){
			System.out.println(permutations.get(i));
		}
	} 
}