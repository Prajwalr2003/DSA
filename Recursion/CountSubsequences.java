import java.util.*;

class CountSubsequences{
	public static int f(int i, int sum, int[] arr, int tar, int n){
		// if array strictly contains positive elements
		if(s>sum) return 0;
		if(i==n){
			if(sum==tar){
				return 1;
			}
			return 0;
		}

		sum += arr[i];
		int pick = f(i+1, sum, arr, tar, n);

		sum -= arr[i];
		int notPick = 0+f(i+1, sum, arr, tar, n);

		return pick+notPick;

	} 

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = {1, 2, 1};
		int tar = 2;
		System.out.println(f(0, 0, arr, tar, n));
	} 
}     