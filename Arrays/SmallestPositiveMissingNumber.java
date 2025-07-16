public class SmallestPositiveMissingNumber {
    
    public static int missingNumber(int arr[]){
        int n = arr.length;

        for(int i=0;i<n;i++){
            int correctIndex=arr[i]-1;
            if(arr[i]>0 && arr[i]<=n && arr[i]!=arr[correctIndex])
            {
                int temp=arr[i];
                arr[i]=arr[correctIndex];
                arr[correctIndex]=temp;
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args){

        int arr[] = {1,2,3,4,5};

        System.out.println(missingNumber(arr));

    }
}
