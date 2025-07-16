public class MaximumProductSubarray {

    public static long  maxSubarray(int arr[], int n){

        long prefix=1, suffix=1;
        long max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            
            if(prefix==0){
                prefix=1;
            }

            if(suffix==0){
                suffix=1;
            }

            prefix *= arr[i];
            suffix *= arr[n-i-1];

            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }
    
    public static void main(String[] args){

        int arr[] = { 6, -3, -10, 10, 0, 2};
        int n=arr.length;

        System.out.println(maxSubarray(arr, n));
    }
}
