import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

    public static void reverse(int arr[], int first, int last){
        while(first<last){
            int temp=arr[first];
            arr[first]=arr[last];
            arr[last]=temp;
            first++;
            last--;
        }
    }

    public static List<Integer> nextPermutation(int arr[]){

        ArrayList<Integer> res = new ArrayList<>();
        int index=-1;
        int n=arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index=i;
                break;
            }
        }

        if(index==-1){
            reverse(arr, 0, n-1);
            for(int i=0;i<n;i++){
                res.add(arr[i]);
            }
            return res;
        }

        for(int i=n-1;i>index;i--){
            if(arr[i]>arr[index]){
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                break;
            }
        }

        reverse(arr, index+1, n-1);
        for(int i=0;i<n;i++){
            res.add(arr[i]);
        }
        return res;
    }
    public static void main(String[] args){
        // int[] arr = {1, 2, 3, 6, 5, 4};
        int[] arr = { 2, 3, 1};

        System.out.println(nextPermutation(arr));
    }
}
