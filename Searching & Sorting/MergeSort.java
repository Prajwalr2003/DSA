public class MergeSort {

    public static void mergeSort(int arr[], int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int n = arr.length;
        int brr[] = new int[n];
        int h = low, i = low, j = mid + 1;

        while (h <= mid && j <= high) {
            if (arr[h] <= arr[j]) {
                brr[i] = arr[h];
                h++;
            } else {
                brr[i] = arr[j];
                j++;
            }
            i++;
        }

        // Copy the remaining elements from the left subarray, if any
        while (h <= mid) {
            brr[i] = arr[h];
            h++;
            i++;
        }

        // Copy the remaining elements from the right subarray, if any
        while (j <= high) {
            brr[i] = arr[j];
            j++;
            i++;
        }

        // Copy the merged elements back to the original array
        for (int k = low; k <= high; k++) {
            arr[k] = brr[k];
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 2, 3};
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        printArray(arr);
    }
}
