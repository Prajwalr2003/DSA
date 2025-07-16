public class MissingNumberInArray {

    public static int findMissingNumber(int arr[], int n){

        int totalSum = (n)*(n+1)/2;
        int sum=0;

        for(int i=0;i<n-1;i++){
            sum = sum + arr[i];
        }

        return totalSum-sum;
    }
    
    public static void main(String[] args){

        int arr[] = { 1, 2, 4, 5};
        int n=arr.length+1;
        System.out.println(findMissingNumber(arr, n));
    }
}
