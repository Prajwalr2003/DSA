import java.util.ArrayList;
public class FindingDuplicatesInArray {
    
    public static ArrayList<Integer> findDuplicates(int arr[], int n){
        
        ArrayList<Integer> res = new ArrayList<>();

        int index=0;

        for(int i=0;i<n;i++){

            index = Math.abs(arr[i])-1;

            if(arr[index]<0){
                res.add(Math.abs(arr[i]));
            }

            arr[index]=-arr[index];
        }

        return res;
    }
    public static void main(String[] args){

        int arr[] = { 1, 1, 2, 2, 3, 4, 5, 6, 6};
        int n = arr.length;

        System.out.println(findDuplicates(arr, n));
    }
}
