
public class ReverseAnArray {

    public static void reverseArray(int arr[]) {

        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args){

        int arr[] = {1,3,4,2,5,3,9};

        reverseArray(arr);
    }
}
