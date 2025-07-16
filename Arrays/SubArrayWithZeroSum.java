
import java.util.HashSet;

public class SubArrayWithZeroSum {

    public static boolean isSubarrayExist(int arr[]){

        HashSet<Integer> set = new HashSet<>();

        int pre_sum = 0;

        for(int i=0;i<arr.length;i++){
            pre_sum += arr[i];

            if(pre_sum == 0){
                return true;
            }

            if(set.contains(pre_sum)){
                return true;
            }

            set.add(pre_sum);
        }

        return false;

    }

    public static void main(String[] args){

        int arr[] = {1 ,5 ,2 -3, 1};

        System.out.println(isSubarrayExist(arr));
    }
}
