import java.util.*;

class UniqueCombinationSum{

	public static void f(int ind, int target, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> combs){
		if(target==0){
			combs.add(new ArrayList<>(list));
			return;
		}

		for(int i=ind; i<arr.length; i++){
			if(i>ind && arr[i]==arr[i-1]) continue;
			if(arr[i]>target) break;

			list.add(arr[i]);
			f(i+1, target-arr[i], arr, list, combs);
			list.remove(list.size()-1);
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int arr[] = {1,1,1,2,2};
		int n = sc.nextInt();
		int target=5;
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<ArrayList<Integer>> combs = new ArrayList<>();
		Array.sort(arr);
		f(0, target, arr, list, combs);

		for(int i=0; i<combs.size() ;i++){
			System.out.print(combs.get(i)+" ");
		}
	} 
}