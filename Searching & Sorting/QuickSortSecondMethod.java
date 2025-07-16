public class QuickSortSecondMethod {

    public static void quickSort(int arr[], int low, int high){
        if(low<high){
            int j = partition(arr, low, high);
            quickSort(arr, low, j-1);
            quickSort(arr, j+1, high);
        }
    }
    
    public static int partition(int arr[], int low, int high){
        int v = arr[low];
        int i=low+1, j=high;

        while(i<=j){
            while(i <= j && arr[i] <= v){
                i++;
            }

            while(i <= j && arr[j] > v){
                j--;
            }

            if(i<j){
                interchange(arr, i, j);
            }
        }

        interchange(arr, low, j);

        return j;
    }

    public static void interchange(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int arr[] = { 5, 4, 1, 2, 3};

        quickSort(arr, 0, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
