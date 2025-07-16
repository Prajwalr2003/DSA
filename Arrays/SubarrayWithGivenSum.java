import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static ArrayList<Integer> subarraySum(int[] arr, int N, int S) 
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        int left=0, right=0, sum=0;
        
        while(right<N){
            
            sum += arr[right];
            
            while (sum > S && left <= right) {
                sum -= arr[left];
                left++;
            }

            if(sum == S){
                result.add(left+1);
                result.add(right+1);
                break;
            }
            
            right++;
        }

        if (result.isEmpty()) {
            result.add(-1); // If no subarray found
        }    

        return result;
    }
}
