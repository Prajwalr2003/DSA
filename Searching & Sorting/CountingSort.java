public class CountingSort {
  public static void countingSort(int arr[]) {
    int n = arr.length;
    int largest = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      largest = Math.max(largest, arr[i]);
    }
    int count[] = new int[largest + 1];
    for (int i = 0; i < arr.length; i++) {
      count[arr[i]]++;
    }
    int idx = 0;
    for (int i = 0; i < count.length; i++) {
      int cnt = count[i];
      while (cnt > 0) {
        arr[idx++] = i;
        cnt--;
      }
    }
  }

  public static void main(String args[]) {
    int arr[] = { 5, 4, 3, 2, 1, 1, 2, 3, 4, 5 };
    countingSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
