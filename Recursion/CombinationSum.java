import java.util.*;

class CombinationSum{

	public static void f(int i, int target, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> combs){

		if(i==arr.length){
			if(target==0){
				combs.add(new ArrayList<>(list));
			}
			return;
		}

		if(arr[i]<=target){
			list.add(arr[i]);
			f(i, target-arr[i], arr, list, combs);
			list.remove(list.size()-1);
		}

		f(i+1, target, arr, list, combs);
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int arr[] = {2, 2, 3};
		int n = sc.nextInt();
		int target=7;
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<ArrayList<Integer>> combs = new ArrayList<>();

		f(0, target, arr, list, combs);
		for(int i=0; i<combs.size() ;i++){
			System.out.print(combs.get(i)+" ");
		}
	} 
}