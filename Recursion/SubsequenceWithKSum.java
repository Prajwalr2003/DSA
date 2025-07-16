import java.util.*;

class SubsequenceWithKSum{
	public static void f(int i, int sum, ArrayList<Integer> list, int[] arr, int tar, int n){
		if(i==n){
			if(sum==tar){
				for(int it: list){
					System.out.print(it+" ");
				}
				System.out.println();
			}
			return;
		}

		list.add(arr[i]);
		sum += arr[i];
		f(i+1, sum, list, arr, tar, n);
		list.remove(list.size()-1);
		sum -= arr[i];
		f(i+1, sum, list, arr, tar, n);
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