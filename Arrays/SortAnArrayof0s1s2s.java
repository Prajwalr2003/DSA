public class SortAnArrayof0s1s2s {

    public static void sortAnArray(int arr[]) {

        // Dutch Flag National Algorithm
        int low = 0, high = arr.length-1, mid = 0;

        while (mid <= high) {

            switch (arr[mid]) {

                case 0:
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    mid++;
                    low++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 0, 0, 1, 2, 0};
        sortAnArray(arr);
    }
}
