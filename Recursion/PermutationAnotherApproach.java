import java.util.*;

class PermutationAnotherApproach{

	public static void f(int ind, int[] arr, List<List<Integer>> permutations){
		if(ind == arr.length){
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<arr.length; i++){
				list.add(arr[i]);
			}
			permutations.add(new ArrayList<>(list));
			return;
		}
		for(int i=ind; i<arr.length; i++){

			swap(i, ind, arr);
			f(ind+1, arr, permutations);
			swap(i, ind, arr);

		}
	}
	private static void swap(int i, int ind, int[] arr){
		int temp=arr[i];
		arr[i]=arr[ind];
		arr[ind]=temp;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = {1, 3, 2};
		List<List<Integer>> permutations =  new ArrayList<>();

		f(0, arr, permutations);

		for(int i=0 ; i<permutations.size(); i++){
			System.out.println(permutations.get(i));
		}
	} 
}