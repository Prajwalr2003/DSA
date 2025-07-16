import java.util.Arrays;
public class MoveAllZerosToEnd {

    public static void moveAllZeros(int arr[]){

        int n = arr.length;

        int z=0, nz=0;

        while(nz<n){
            if(arr[nz]!=0){
                int temp=arr[nz];
                arr[nz]=arr[z];
                arr[z]=temp;
                nz++;
                z++;
            }
            else{
                nz++;
            }
        }
    }
    
    public static void main(String[] args){

        int arr[] = { 3, 2, 0, 5, 6, 0, 0, 1};
        
        moveAllZeros(arr);

        System.out.println(Arrays.toString(arr));
    }
}
