public class QuickSort
{
    public static int partition(int arr[], int low, int high){

        int pivot = arr[high];
        int i=low-1;

        for(int j=low;j<high;i++){

            if(arr[j]<pivot){
                i++;
                int temp=pivot;
                pivot=arr[j];
                arr[j]=temp;
            }
        }
        
        i++;
        int temp=pivot;
        pivot=arr[i];
        arr[i]=temp;

        return i;
    }

    public static void quickSort(int arr[], int low, int high){
        if(low<high){
            int pivotIndex=partition(arr,low,high);

            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1,high);
        }
    }
    public static void main(String[] args){
        int[] arr = {10,11,89, 6};
        int n = arr.length;

        quickSort(arr, 0, n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}