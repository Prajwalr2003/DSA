public class CyclicallyRotateArray {

    public static void rotate(int[] arr){
        int temp = arr[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            arr[arr.length-1-i] = arr[arr.length-2-i];
        }
        arr[0]=temp;    

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void main(String[] args){
        int[] arr= {1,2,3,4,5};
        rotate(arr);
    }
}
