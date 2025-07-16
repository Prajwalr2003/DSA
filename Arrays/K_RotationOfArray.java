public class K_RotationOfArray {
    public static void rotateOne(int[] arr){
        int temp=arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
    }

    public static void kRotateArray(int arr[], int k){

        int n = arr.length;
        k = k%n;
        if(k<0){
            k = k+n;
        }

        for(int i=0;i<k;i++){
            rotateOne(arr);
        }

        // Printing the array 
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        int k=3;
        kRotateArray(arr, k);
    }
}
