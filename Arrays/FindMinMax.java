
import java.util.Scanner;

public class FindMinMax {

    public static void getMinMax(int[] arr){
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            if(max<arr[i]){
                max = arr[i];
            }
            
            if(min>arr[i]){
                min=arr[i];
            }
        }

        System.out.print("Max = "+max+" Min = "+min);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.print("Enter Elements in an array : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        getMinMax(arr);
        
        sc.close();
    }
}
