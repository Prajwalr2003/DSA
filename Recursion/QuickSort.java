import java.util.*;

class QuickSort{

	public static int f(int arr[], int low, int high){
		int pivot=arr[low];
		int i=low;
		int j=high;

		while(i<j){
			while(arr[i]<=pivot && i<=high-1){
				i++;
			}

			while(arr[j]>pivot && j>=low+1){
				j--;
			}
			if(i<j){
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}

		int temp=arr[low];
		arr[low]=arr[j];
		arr[j]=temp;

		return j;
	}

	public static void quickSort(int[] arr, int low, int high){
		if(low<high){
			int pIndex = f(arr, low, high);
			quickSort(arr, low, pIndex-1);
			quickSort(arr, pIndex+1, high);
		}
	} 

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = {3, 2, 4, 1, 3};
		quickSort(arr, 0, n-1);

		for(int i=0; i<n ;i++){
			System.out.print(arr[i]+" ");
		}
	} 
}     