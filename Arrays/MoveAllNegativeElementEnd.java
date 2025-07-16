
import java.util.*;
public class MoveAllNegativeElementEnd {

    public static void optimizeSolution(int[] arr){

        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                posList.add(arr[i]);
            }
            if(arr[i]<0){
                negList.add(arr[i]);
            }
        }

        posList.addAll(negList);

        for(int i=0;i<n;i++){
            System.out.print(posList.get(i)+" ");
        }
    }

    public static void moveAllNegativeElements(int[] arr){
        int n=arr.length;
        int temp[] =  new int[n];
        int j=0;

        //Brute Force Solution
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                temp[j]=arr[i];
                j++;
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i]<0){
                temp[j]=arr[i];
                j++;
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(temp[i]+" ");
        }
    }
    public static void main(String[] args){
        int arr[] = { 1,-1,3,2,-7,-5,11,6};
        // moveAllNegativeElements(arr);
        optimizeSolution(arr);
    }
}
