public class SelectionSort {
  public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int sm = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
          sm = j;
        }
      }
      int temp = arr[sm];
      arr[sm] = arr[i];
      arr[i] = temp;
    }
  }

  public static void main(String args[]) {
    int arr[] = { 5, 4, 3, 2, 1 };
    selectionSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
