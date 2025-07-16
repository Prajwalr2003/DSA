import java.util.*;
public class SubarrayWith0Sum {
    
    public static boolean isSubarray(int arr[] , int n){

        HashSet<Integer> res= new HashSet<>();

        int pre_sum=0;
        for(int i=0;i<n;i++){

            pre_sum += arr[i];

            if(pre_sum == 0){
                return true;
            }

            if(res.contains(pre_sum)){
                return true;
            }

            res.add(pre_sum);
        }

        return false;
    }

    public static void main(String[] args){
        int arr[] = {15,-2,2,-8,1,7,10,23};
        int n = arr.length;

        // System.out.println(isSubarray(arr, n));

        HashMap<Integer, Integer> res = new HashMap<>();

        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum + arr[i];
            res.put(sum,1);
        }

        for(int key : res.keySet()){
            System.out.println(key+" ");
        }
    }
}
