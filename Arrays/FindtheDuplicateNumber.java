public class FindtheDuplicateNumber {

    // for finding only one repeated number where numbers in array
    // belongs from [1, n];

    public static int findDuplicate(int arr[]){
        int n = arr.length;
        int brr[] = new int[n];

        for(int i=0;i<n;i++){
            brr[arr[i]]++;
        }

        for(int i=0;i<n;i++){
            if(brr[i]>1){
                return i;
            }
        }
        return n;
    }

    public static int getDuplicate(int arr[]){
 
        int slow=arr[0];
        int fast=arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow!=fast);

        fast = arr[0];

        while(slow!=fast){
            slow=arr[slow];
            fast=arr[fast];
        }

        return fast;
    }
    public static void main(String[] args){
        int arr[] = { 1, 3, 4, 4, 2};
        // System.out.println(findDuplicate(arr));
        System.out.println(getDuplicate(arr));
    }
}
