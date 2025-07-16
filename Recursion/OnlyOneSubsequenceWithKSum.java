import java.util.*;

class Recursion{
	public static boolean f(int i, int sum, ArrayList<Integer> list, int[] arr, int tar, int n){
		if(i==n){
			// Condition satisfied
			if(sum==tar){
				for(int it: list){
					System.out.print(it+" ");
				}
				System.out.println();
				return true;
			}
			return false;
		}

		list.add(arr[i]);
		sum += arr[i];

		if(f(i+1, sum, list, arr, tar, n)==true) return true;
		
		list.remove(list.size()-1);
		sum -= arr[i];
		if(f(i+1, sum, list, arr, tar, n)==true) return true;

		return false;
	} 

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		int arr[] = {1, 2, 1};
		int tar = 2;
		f(0, 0, list, arr, tar, n);
	} 
}     